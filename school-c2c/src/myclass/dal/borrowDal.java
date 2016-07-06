package myclass.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myclass.bol.borrowBook;

public class borrowDal {
	public borrowBook getborrowByReaderIdBookId(String readerId, String bookId) {
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from borrowBook where 读者号='" + readerId
				+ "' and 图书号='" + bookId + "'";
		ResultSet rs = da.query(sql);
		 borrowBook bb = new borrowBook();
		try {
			if (rs.next()) {
				bb.setBookID(rs.getString("图书号"));
				bb.setReaderID(rs.getString("读者号"));
				bb.setBookID(rs.getString("借书日期"));
				bb.setReturnDate(rs.getString("还书日期"));
			} else {
				bb = null;
			}

		} catch (SQLException e) {
			// TODO: handle exception
			// return null;
			bb = null;
		} finally {
			da.closeConnection();
		}
		return bb;
	}
	//插入借阅记录——借书
	public int insertBorrowBook(String readerId, String bookId,
			String borrowDate, String returnDate) {
		String sql = "insert into borrowBook values('" + readerId + "','"
				+ bookId + "','" + borrowDate + "','" + returnDate + "')";
		DBAccess da = new DBAccess();
		da.getConn();
		int result = da.executeSql(sql);
		da.closeConnection();
		return result;
	}
	//删除借书记录——还书
	public int deleteBorrowBook(String readerID, String bookID) {
		DBAccess da = new DBAccess();
		int result = 0;
		try {
			if (da.getConn() != null) {
				PreparedStatement pstmt;
				String sql = "delete from borrowBook where 读者号='" + readerID
						+ "' and 图书号='" + bookID + "'";
				pstmt = da.getConn().prepareStatement(sql);
				pstmt.setString(1, readerID);
				pstmt.setString(2, bookID);
				result = pstmt.executeUpdate();
				if (pstmt != null) {
					pstmt.close();
					pstmt = null;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			da.closeConnection();
		}
		return result;
	}

	public borrowBook getBorrowByID(String readerID, String bookID){
		DBAccess da=new DBAccess();
		//da.getConn();
		//borrowBook bb=new borrowBook();
		borrowBook bb=null;
		String sql="select * from borrowBook where  读者号='"+readerID+"' and  图书号='"+bookID+"'";
		try {
			if(da.getConn() != null && readerID != null && bookID != null){
				ResultSet rs=da.query(sql);
				if(rs != null && rs.next()){
					bb=new borrowBook(rs.getString("读者号"),rs.getString("图书号"),rs.getString("借书日期"),rs.getString("还书日期"));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			da.closeConnection();
		}
		return bb;
	}
}
