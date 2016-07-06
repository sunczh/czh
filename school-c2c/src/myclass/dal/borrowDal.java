package myclass.dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import myclass.bol.borrowBook;

public class borrowDal {
	public borrowBook getborrowByReaderIdBookId(String readerId, String bookId) {
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from borrowBook where ���ߺ�='" + readerId
				+ "' and ͼ���='" + bookId + "'";
		ResultSet rs = da.query(sql);
		 borrowBook bb = new borrowBook();
		try {
			if (rs.next()) {
				bb.setBookID(rs.getString("ͼ���"));
				bb.setReaderID(rs.getString("���ߺ�"));
				bb.setBookID(rs.getString("��������"));
				bb.setReturnDate(rs.getString("��������"));
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
	//������ļ�¼��������
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
	//ɾ�������¼��������
	public int deleteBorrowBook(String readerID, String bookID) {
		DBAccess da = new DBAccess();
		int result = 0;
		try {
			if (da.getConn() != null) {
				PreparedStatement pstmt;
				String sql = "delete from borrowBook where ���ߺ�='" + readerID
						+ "' and ͼ���='" + bookID + "'";
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
		String sql="select * from borrowBook where  ���ߺ�='"+readerID+"' and  ͼ���='"+bookID+"'";
		try {
			if(da.getConn() != null && readerID != null && bookID != null){
				ResultSet rs=da.query(sql);
				if(rs != null && rs.next()){
					bb=new borrowBook(rs.getString("���ߺ�"),rs.getString("ͼ���"),rs.getString("��������"),rs.getString("��������"));
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
