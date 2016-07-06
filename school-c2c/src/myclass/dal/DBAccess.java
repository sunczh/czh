package myclass.dal;
import java.sql.*;
public class DBAccess {
	private Connection con=null;
	private Statement stmt=null;
	private ResultSet rs=null;
	private PreparedStatement pstmt=null;
	public DBAccess(){}
	/**���ݿ����ӷ��������Connection����**/
	public Connection getConn(){
		if(con==null){
			getConnection();
		}
		return con;	
	}
	/**���ݿ����ӷ���,���Statement����**/
	public void getConnection()
	{
		try{
			  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();      //��ʽ�ؼ���JDBC����API��������
		      String url = "jdbc:sqlserver://localhost:1433;DatabaseName=shopper";
		      String user="sa";
		      String pwd="123456";
		      this.con = DriverManager.getConnection(url,user, pwd);   //����Connection����con,bookΪSQLServer���ݿ�����
		      this.stmt=this.con.createStatement();
		}
		catch(Exception e){
			e.getStackTrace();
		}
	}
	/**���ݿ��ѯ����,���ResultSet����**/
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
	/**���ݿ��ѯ����,���ò�ѯԤ������󣬻��ResultSet����**/	
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
	/**���ݿ���·���������Ӱ������**/
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
	/**���ݿ���·��������ò�ѯԤ�������,����Ӱ������**/
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
	/**�ر�����**/	
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
