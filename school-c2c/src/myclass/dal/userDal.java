package myclass.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import myclass.bol.userInfo;
//登录
public class userDal {
	public userInfo getreaderByIDPwd(String userName, String userPwd) {
		userInfo user = new userInfo();
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from usr where 用户名='" + userName
				+ "'and 密码='" + userPwd + "'";
		ResultSet rs = da.query(sql);
		try {
			if (rs != null && rs.next()) {
				user.setUserName(rs.getString("用户名"));
				user.setUserPhone(rs.getString("手机号"));
				user.setUserEmail(rs.getString("email"));
				user.setAuthority(rs.getString("权限"));
				
			}
			// System.out.println("搜到了");
			// }else{
			// reader = null;
			// System.out.println("没搜到");
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
//查询信息
	public userInfo getreaderByID(String userID) {
		userInfo user = new userInfo();
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from usr where 用户名='" + userID + "'";
		ResultSet rs = da.query(sql);
		try {
			if (rs != null && rs.next()) {
				user.setUserName(rs.getString("用户名"));
				user.setUserPhone(rs.getString("手机号"));
				user.setUserEmail(rs.getString("email"));
				user.setRealName(rs.getString("姓名"));
				user.setRegisterDate(rs.getString("注册日期"));
				user.setUserPassword(rs.getString("密码"));
				user.setAuthority(rs.getString("权限"));
				

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
	//更改密码
	public int updateuserPwd(String userID,String password)
	{
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "update readerInfo set 密码='"+password+"' where 用户名='"+userID+"'";
		int r= da.executeSql(sql);
		da.closeConnection();
		return r;
	}
	//增加用户

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
