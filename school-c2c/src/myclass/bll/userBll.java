package myclass.bll;

import java.io.UnsupportedEncodingException;
import myclass.bol.userInfo;
import myclass.dal.userDal;

public class userBll {

	//��½��֤
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
	//ע����֤
	public String userRegistration(String loginID, String loginPwd1,String loginPwd2,String email,String userPhone,String secondPwd) {
		String result = "";
		userDal u=new userDal();
		if(u.getreaderByID(loginID)!=null){
			result=result+"�û����Ѵ���;";
		}
		if(loginID.length()>20||loginID.length()<6)
		result=result+"�û������Ȳ����ϣ�Ҫ��6��20���ַ�֮�䣻";
		String regex = "^[0-9a-zA-Z]{6,16}$";
		if(!loginPwd1.equals(loginPwd2))
			result=result+"����������û������벻ͬ;";
		if(loginPwd1.length()>20||loginPwd1.length()<6)
			result=result+"�û������볤�Ȳ����ϣ�Ҫ��6��20���ַ�֮��;";
		if(!loginPwd1.matches(regex))
		{
			result=result+"�û��������ʽ����ȷ;";
		}
		 String format = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		 if (!email.matches(format)) {
			 result=result+"�����ʽ����;";
		 }
		 if (!userPhone.matches("^1[3|4|5|7|8][0-9]\\d{8}$")&&userPhone.length()!=0) {
			 result=result+"�ֻ���ʽ����;";
		 }
		 if (!secondPwd.matches("^[0-9]*$")||secondPwd.length()!=8) {
			 result=result+"���������ʽ����;";
		 }
		return result;
	}
	//ת��utf-8
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
	//��ʾ������Ϣ
	public ArrayList<bookInfo> getBookAll() {
		bookDal bd = new bookDal();
		return bd.getBookAll();
	}
	//��������ʾ��Ϣ
	public ArrayList<bookInfo> getBookByCondition(String col, String keyword) {
		bookDal bd = new bookDal();
		return bd.getBookByCondition(col, keyword);
	}

	

	public bookBorrowBean readerBorrowBook(String bookId, String readerId) {
		// 1.��֤�����Ƿ����
		bookBorrowBean bbb = new bookBorrowBean();
		readerDal rd = new readerDal();
		readerInfo ri = rd.getreaderByID(readerId);
		if (ri == null) {
			bbb.setReturnMessage("���߲�����");
			return bbb;
		}
		bbb.setReaderId(ri.getReaderID());
		bbb.setReaderName(ri.getReaderName());
		bbb.setReaderType(ri.getReaderType());
		// 2.��֤ͼ�� �Ƿ���ڣ������Ƿ�>0
		bookDal bd = new bookDal();
		bookInfo bi = bd.getBookByID(bookId);
		if (bi == null) {
			bbb.setReturnMessage("ͼ�鲻����");
			return bbb;
		}
		if (bi.getBookNum() < 1) {
			bbb.setReturnMessage("ͼ����������");
			return bbb;
		}
		bbb.setBookId(bi.getBookID());
		bbb.setBookName(bi.getBookName());
		// 3.��֤�����Ƿ��Ѿ�����Ȿ��
		borrowDal bod = new borrowDal();
		borrowBook bob = bod.getborrowByReaderIdBookId(readerId, bookId);
		if (bob != null) {
			bbb.setReturnMessage("�ö����Ѿ�����Ȿ��");
			return bbb;
		}
		// 4.��borrowBook����뱾�ν����¼
		Calendar ca = Calendar.getInstance();
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		String borrowDate = myFormatter.format(ca.getTime());
		String returnDate = "";
		if (bbb.getReaderType().equals("ѧ��")) {
			ca.add(Calendar.MONTH, +3);
			returnDate = myFormatter.format(ca.getTime());
		} else {
			ca.add(Calendar.MONTH, +6);
			returnDate = myFormatter.format(ca.getTime());
		}
		if (bod.insertBorrowBook(readerId, bookId, borrowDate, returnDate) != 1) {
			bbb.setReturnMessage("�����¼������� ");
			return bbb;
		}
		bbb.setBorrowDate(borrowDate);
		bbb.setReturnDate(returnDate);

		// 5.�ѱ�������-1
		if (bd.subbookNum(bookId) != 1) {
			bbb.setReturnMessage("ͼ����������-1");
			return bbb;
		}
		// 6.�ɹ�����
		bbb.setReturnMessage("����ɹ�");
		return bbb;
	}

	// �����޸�
	public modifyPasswordBean modifyPasswordByReaderId(String readerId,
			String oldPwd, String newPwd) {
		modifyPasswordBean mpb = new modifyPasswordBean();
		mpb.setOldPwd(oldPwd);

		readerDal rd = new readerDal();
		readerInfo ri = rd.getreaderByIDPwd(readerId, oldPwd);
		if (ri == null) {
			mpb.setReturnMessage("�ö��߲����ڣ����߾����벻��ȷ");
		}

		int r = rd.updateReaderPwd(readerId, newPwd);
		if (r > 0) {
			mpb.setNewPwd(newPwd);
			mpb.setReaderID(readerId);
			mpb.setReturnMessage("������ĳɹ�");
		} else {
			mpb.setReturnMessage("�������ݿ�ʧ��");
			return mpb;
		}
		return mpb;

	}
	//��ҳ	
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
	
	
	// ɾ������
	public int deleteBorrowBook(String bookId) {
		userDal bd = new userDal();
		return bd.deleteBookById(bookId);
	}
	//����
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

	
	//���ݶ��ߺţ����Ҷ�����Ϣ
	public  readerInfo getreaderByID(String readerID){
		 readerDal rl=new readerDal();
		 return rl.getreaderByID(readerID);
	}
	//������ţ����Ҷ�����Ϣ
	public bookInfo getBookByID(String bookID){
		bookDal bd=new bookDal();
	    return bd.getBookByID(bookID);
	}
	public borrowBook getBorrowByID(String readerID, String bookID){
	     borrowDal bd=new borrowDal();
	     return bd.getBorrowByID(readerID, bookID);
	}
	
	//����ͼ����Ϣ
	public int updateBook(String bookid,String bookname,String author,String publish,String booktype,String booknum){
		bookDal bd=new bookDal();
		System.out.println("����");
		return bd.updateBook(bookid, bookname, author, publish, booktype, booknum);
	}
*/
}
