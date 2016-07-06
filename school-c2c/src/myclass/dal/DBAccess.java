package myclass.dal;
import java.sql.*;
public class DBAccess {
	private Connection con=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private PreparedStatement pstmt=null;
	public DBAccess(){}
	/**数据库连接方法，获得Connection对象**/
	public Connection getConn(){
		if(con==null){
			getConnection();
		}
		return con;	
	}
	/**数据库连接方法,获得Statement对象**/
	public void getConnection()
	{
		try{
			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();      //显式地加载JDBC本地API驱动程序
		      String url = "jdbc:sqlserver://localhost:1433;DatabaseName=shopper";
		      String user="sa";
		      String pwd="123456";
		      this.con = DriverManager.getConnection(url,user, pwd);   //创建Connection对象con,book为SQLServer数据库名称
		      this.stmt=this.con.createStatement();
		}
		catch(Exception e){
			e.getStackTrace();
		}
	}
	/**数据库查询方法,获得ResultSet对象**/
	public ResultSet query(String strSql){
		ResultSet rs=null;
		try{
			rs=stmt.executeQuery(strSql);
			return rs;
		}catch(SQLException e){
			e.printStackTrace();
			return rs;
		}
	}
	/**数据库查询方法,利用查询预处理对象，获得ResultSet对象**/	
	public ResultSet query(PreparedStatement pstmt){
		this.pstmt=pstmt;
		ResultSet rs=null;
		try{
			rs=this.pstmt.executeQuery();
			return rs;
		}catch(SQLException e){
			e.printStackTrace();
			return rs;
		}
	}
	/**数据库更新方法，返回影响行数**/
	public int executeSql(String strSql){
		int result=0;
		try{
			stmt=con.createStatement();
			result=stmt.executeUpdate(strSql);
		}catch(SQLException e){
			e.printStackTrace();
			result=-1;
		}
		return result;
	}
	/**数据库更新方法，利用查询预处理对象,返回影响行数**/
	public int executeSql(PreparedStatement pstmt){
	int result=0;
	try{
		this.pstmt=pstmt;
		result=this.pstmt.executeUpdate();
	}catch(SQLException e){
		e.printStackTrace();
		result=-1;
	}
	return result;
}
	/**关闭连接**/	
	public void closeConnection(){
		try{
			if(rs!=null)
			{rs.close();
			 rs=null;
			 }
			if(stmt!=null)
			{stmt.close();
			 stmt=null;
			 }
			if(con!=null)
			{con.close();
			 con=null;
			 }
			if(pstmt!=null)
			{pstmt.close();
			pstmt=null;
			 }
			
		}catch(SQLException e){
			e.printStackTrace();
		}
	} 
}
