package myclass.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import myclass.bol.userInfo;
//��¼
public class userDal {
	public userInfo getreaderByIDPwd(String userName, String userPwd) {
		userInfo user = new userInfo();
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from usr where �û���='" + userName
				+ "'and ����='" + userPwd + "'";
		ResultSet rs = da.query(sql);
		try {
			if (rs != null && rs.next()) {
				user.setUserName(rs.getString("�û���"));
				user.setUserPhone(rs.getString("�ֻ���"));
				user.setUserEmail(rs.getString("email"));
				user.setAuthority(rs.getString("Ȩ��"));
				
			}
			// System.out.println("�ѵ���");
			// }else{
			// reader = null;
			// System.out.println("û�ѵ�");
			// }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			user = null;
		} finally {
			da.closeConnection();
		}

		return user;
	}
//��ѯ��Ϣ
	public userInfo getreaderByID(String userID) {
		userInfo user = new userInfo();
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from usr where �û���='" + userID + "'";
		ResultSet rs = da.query(sql);
		try {
			if (rs != null && rs.next()) {
				user.setUserName(rs.getString("�û���"));
				user.setUserPhone(rs.getString("�ֻ���"));
				user.setUserEmail(rs.getString("email"));
				user.setRealName(rs.getString("����"));
				user.setRegisterDate(rs.getString("ע������"));
				user.setUserPassword(rs.getString("����"));
				user.setAuthority(rs.getString("Ȩ��"));
				

			} else {
				user = null;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			user = null;
		} finally {
			da.closeConnection();
		}

		return user;
	}
	//��������
	public int updateuserPwd(String userID,String password)
	{
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "update readerInfo set ����='"+password+"' where �û���='"+userID+"'";
		int r= da.executeSql(sql);
		da.closeConnection();
		return r;
	}
	//�����û�

	public int addUser(String loginID, String password,String email,String userPhone,
			String realName,String authority,String secondPwd,String date,String others)
	{
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "insert into usr values('" + loginID + "','"
				+ password + "','" + email + "','" + userPhone + "','"+realName+"','"+authority+"','"+secondPwd+"','"+date+"',"+"'','"+others+"')";
		System.out.println(sql);
		int r= da.executeSql(sql);
		da.closeConnection();
		return r;
	}
}
