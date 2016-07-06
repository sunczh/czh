package myclass.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mybean.model.cartBean;
import myclass.bol.goodsInfo;

public class cartDal {
	//���չ�����ID��ѯ���ﳵ
	public ArrayList<cartBean> getcartBybuyerID(String buyerID) {
		
		DBAccess da = new DBAccess();
		da.getConn();
		ArrayList<cartBean> list = new ArrayList<cartBean>();
		String sql = "select * from cart where �������û���='" + buyerID + "'";
		ResultSet rs = da.query(sql);
		try {
			while (rs.next()){
				cartBean buyer = new cartBean();
				buyer.setBuyerName(rs.getString("�������û���"));
				buyer.setBuyType(rs.getString("����״̬"));
				buyer.setCartId(rs.getInt("������"));
				buyer.setGoodsDiscription(rs.getString("����"));
				buyer.setGoodsId(rs.getInt("������"));
				buyer.setGoodsName(rs.getString("��������"));
				buyer.setGoodsPrice(rs.getString("�۸�"));
				buyer.setGoodsType(rs.getString("��������"));
				buyer.setSellerContact(rs.getString("��������ϵ��ʽ"));
				buyer.setSellerName(rs.getString("�������û���"));
				list.add(buyer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list = null;
		} finally {
			da.closeConnection();
		}
		return list;
	}
	//���ճ�����ID��ѯ����
public ArrayList<cartBean> getcartBysellerID(String sellerID) {
		
		DBAccess da = new DBAccess();
		da.getConn();
		ArrayList<cartBean> list = new ArrayList<cartBean>();
		String sql = "select * from cart where �������û���='" + sellerID + "'";
		ResultSet rs = da.query(sql);
		try {
			while (rs.next()){
				cartBean buyer = new cartBean();
				buyer.setBuyerName(rs.getString("�������û���"));
				buyer.setBuyType(rs.getString("����״̬"));
				buyer.setCartId(rs.getInt("������"));
				buyer.setGoodsDiscription(rs.getString("����"));
				buyer.setGoodsId(rs.getInt("������"));
				buyer.setGoodsName(rs.getString("��������"));
				buyer.setGoodsPrice(rs.getString("�۸�"));
				buyer.setGoodsType(rs.getString("��������"));
				buyer.setSellerContact(rs.getString("��������ϵ��ʽ"));
				buyer.setSellerName(rs.getString("�������û���"));
				list.add(buyer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list = null;
		} finally {
			da.closeConnection();
		}
		return list;
	}
//���ﳵ��Ʒ����
public int	getnumberbybuyerID(String sellerID){
	int number=0;
	DBAccess da = new DBAccess();
	da.getConn();
	String sql = "select count(*) from cart where �������û���='"+sellerID+"'";

	ResultSet rs=da.query(sql);
	try {
		if(rs.next())
		number=rs.getInt(1);
	} catch (Exception e) {
		
		number=0;
	}finally {
		da.closeConnection();
	}	
	
	return number;
}
//�û��ظ���Ʒ����
public int	getchongfu(String buyerId,int goodsId){
	int number=0;
	DBAccess da = new DBAccess();
	da.getConn();
	String sql = "select count(*) from cart where �������û���='"+buyerId+"' and ������="+goodsId;
	ResultSet rs=da.query(sql);
	try {
		if(rs.next())
		number=rs.getInt(1);
	} catch (Exception e) {
		
		number=0;
	}finally {
		da.closeConnection();
	}	
	
	return number;
}
//��ӵ����ﳵ
public int addCart(String buyerName,goodsInfo goods,String buyType)
{
	String goodsName=goods.getGoodsName();
	String description=goods.getDescription();
	int  goodsId=goods.getGoodsId();
	String price=goods.getPrice();
	String goodstype=goods.getGoodstype();
	String contact=goods.getContact();
	String sellerName=goods.getUserName();
	DBAccess da = new DBAccess();
	da.getConn();
	String sql = "insert into cart values('" + goodsId + "','"
			+ goodsName + "','" + sellerName + "','" + contact + "','"+buyerName+"','"+price+"','"+goodstype+"','"+description+"','"+buyType+"')";
	System.out.println(sql);
	int r= da.executeSql(sql);
	da.closeConnection();
	return r;
}
public int	deletecartbyid(int cartid){
	DBAccess da = new DBAccess();
	int result = 0;
	try {
		if (da.getConn() != null) {

			String sql = "delete from cart where  ������=" + cartid;
			System.out.println(sql);
			result = da.executeSql(sql);
		}
	} catch (Exception e) {
		e.printStackTrace();
		return -1;
	} finally {
		da.closeConnection();
	}
	return result;
}
}
