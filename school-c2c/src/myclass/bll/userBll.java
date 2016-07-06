package myclass.bll;

import java.io.UnsupportedEncodingException;
import myclass.bol.userInfo;
import myclass.dal.userDal;

public class userBll {

	//登陆验证
	public userInfo userLogin(String loginID, String loginPwd) {
		userDal rd = new userDal();
		userInfo user = null;
		if ((loginID.length()>5 && loginID.length()<20
				&& loginPwd.length() > 0)) {
			
			user = rd.getreaderByIDPwd(loginID, loginPwd);
			if (user != null) {
				return user;
			} else {
				return null;
			}
		}
		return user;
	}
	//注册验证
	public String userRegistration(String loginID, String loginPwd1,String loginPwd2,String email,String userPhone,String secondPwd) {
		String result = "";
		userDal u=new userDal();
		if(u.getreaderByID(loginID)!=null){
			result=result+"用户名已存在;";
		}
		if(loginID.length()>20||loginID.length()<6)
		result=result+"用户名长度不符合，要在6到20个字符之间；";
		String regex = "^[0-9a-zA-Z]{6,16}$";
		if(!loginPwd1.equals(loginPwd2))
			result=result+"两次输入的用户名密码不同;";
		if(loginPwd1.length()>20||loginPwd1.length()<6)
			result=result+"用户名密码长度不符合，要在6到20个字符之间;";
		if(!loginPwd1.matches(regex))
		{
			result=result+"用户名密码格式不正确;";
		}
		 String format = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		 if (!email.matches(format)) {
			 result=result+"邮箱格式错误;";
		 }
		 if (!userPhone.matches("^1[3|4|5|7|8][0-9]\\d{8}$")&&userPhone.length()!=0) {
			 result=result+"手机格式错误;";
		 }
		 if (!secondPwd.matches("^[0-9]*$")||secondPwd.length()!=8) {
			 result=result+"二级密码格式错误;";
		 }
		return result;
	}
	//转换utf-8
	public String toUtf8(String s){
		String r="";
		try {
			byte[] b= s.getBytes("ISO-8859-1");
			r=new String(b,"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}
	
	
	
	/*
	//显示所有信息
	public ArrayList<bookInfo> getBookAll() {
		bookDal bd = new bookDal();
		return bd.getBookAll();
	}
	//按条件显示信息
	public ArrayList<bookInfo> getBookByCondition(String col, String keyword) {
		bookDal bd = new bookDal();
		return bd.getBookByCondition(col, keyword);
	}

	

	public bookBorrowBean readerBorrowBook(String bookId, String readerId) {
		// 1.验证读者是否存在
		bookBorrowBean bbb = new bookBorrowBean();
		readerDal rd = new readerDal();
		readerInfo ri = rd.getreaderByID(readerId);
		if (ri == null) {
			bbb.setReturnMessage("读者不存在");
			return bbb;
		}
		bbb.setReaderId(ri.getReaderID());
		bbb.setReaderName(ri.getReaderName());
		bbb.setReaderType(ri.getReaderType());
		// 2.验证图书 是否存在，数量是否>0
		bookDal bd = new bookDal();
		bookInfo bi = bd.getBookByID(bookId);
		if (bi == null) {
			bbb.setReturnMessage("图书不存在");
			return bbb;
		}
		if (bi.getBookNum() < 1) {
			bbb.setReturnMessage("图书数量不足");
			return bbb;
		}
		bbb.setBookId(bi.getBookID());
		bbb.setBookName(bi.getBookName());
		// 3.验证读者是否已经借出这本书
		borrowDal bod = new borrowDal();
		borrowBook bob = bod.getborrowByReaderIdBookId(readerId, bookId);
		if (bob != null) {
			bbb.setReturnMessage("该读者已经借出这本书");
			return bbb;
		}
		// 4.向borrowBook表插入本次借书记录
		Calendar ca = Calendar.getInstance();
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String borrowDate = myFormatter.format(ca.getTime());
		String returnDate = "";
		if (bbb.getReaderType().equals("学生")) {
			ca.add(Calendar.MONTH, +3);
			returnDate = myFormatter.format(ca.getTime());
		} else {
			ca.add(Calendar.MONTH, +6);
			returnDate = myFormatter.format(ca.getTime());
		}
		if (bod.insertBorrowBook(readerId, bookId, borrowDate, returnDate) != 1) {
			bbb.setReturnMessage("借书记录不能添加 ");
			return bbb;
		}
		bbb.setBorrowDate(borrowDate);
		bbb.setReturnDate(returnDate);

		// 5.把本书数量-1
		if (bd.subbookNum(bookId) != 1) {
			bbb.setReturnMessage("图书数量不能-1");
			return bbb;
		}
		// 6.成功借书
		bbb.setReturnMessage("借书成功");
		return bbb;
	}

	// 密码修改
	public modifyPasswordBean modifyPasswordByReaderId(String readerId,
			String oldPwd, String newPwd) {
		modifyPasswordBean mpb = new modifyPasswordBean();
		mpb.setOldPwd(oldPwd);

		readerDal rd = new readerDal();
		readerInfo ri = rd.getreaderByIDPwd(readerId, oldPwd);
		if (ri == null) {
			mpb.setReturnMessage("该读者不存在，或者旧密码不正确");
		}

		int r = rd.updateReaderPwd(readerId, newPwd);
		if (r > 0) {
			mpb.setNewPwd(newPwd);
			mpb.setReaderID(readerId);
			mpb.setReturnMessage("密码更改成功");
		} else {
			mpb.setReturnMessage("访问数据库失败");
			return mpb;
		}
		return mpb;

	}
	//分页	
	public ArrayList<userInfo> getBooksByPages(ArrayList<userInfo> listAll,
			int currentpage, int pagerowcpunt) {
		// int pages=listAll.size()/pagerowcpunt;
		int pages = 0;
		ArrayList<userInfo> listnew = new ArrayList<userInfo>();
		int min = 0;
		int max = 0;
		pages = listAll.size() / pagerowcpunt;

		if (listAll.size() % pagerowcpunt != 0) {
			// pages=listAll.size() / pagerowcpunt;
			// }else{
			// pages=listAll.size() / pagerowcpunt;
			pages += 1;
		}
		if (currentpage < pages) {
			min = (currentpage - 1) * pagerowcpunt;
			max = min + pagerowcpunt - 1;
		}
		if (currentpage == pages) {
			min = (currentpage - 1) * pagerowcpunt;
			max = listAll.size() - 1;
		}
		for (int i = min; i <= max; i++) {
			// listAll.get(i);
			listnew.add(listAll.get(i));
		}
		return listnew;
	}
	
	
	// 删除旧书
	public int deleteBorrowBook(String bookId) {
		userDal bd = new userDal();
		return bd.deleteBookById(bookId);
	}
	//还书
//	public int returnBorrowBook(String readerID, String bookID){
//		bookDal bd=new bookDal();
//		bd.AddBookNum(bookID);
//		borrowDal bl=new borrowDal();
//		return bl.deleteBorrowBook(readerID, bookID);
//	}

	public bookBorrowBean returnBorrowBook(String readerID, String bookID){
		bookBorrowBean bbb=new bookBorrowBean();
		
		bookDal bd=new bookDal();
		bd.AddBookNum(bookID);
		borrowDal bl=new borrowDal();
		return bbb;
	}

	
	//根据读者号，查找读者信息
	public  readerInfo getreaderByID(String readerID){
		 readerDal rl=new readerDal();
		 return rl.getreaderByID(readerID);
	}
	//根据书号，查找读者信息
	public bookInfo getBookByID(String bookID){
		bookDal bd=new bookDal();
	    return bd.getBookByID(bookID);
	}
	public borrowBook getBorrowByID(String readerID, String bookID){
	     borrowDal bd=new borrowDal();
	     return bd.getBorrowByID(readerID, bookID);
	}
	
	//更改图书信息
	public int updateBook(String bookid,String bookname,String author,String publish,String booktype,String booknum){
		bookDal bd=new bookDal();
		System.out.println("可以");
		return bd.updateBook(bookid, bookname, author, publish, booktype, booknum);
	}
*/
}
