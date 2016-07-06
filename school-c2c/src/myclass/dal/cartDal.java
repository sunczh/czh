package myclass.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mybean.model.cartBean;
import myclass.bol.goodsInfo;

public class cartDal {
	//按照购买者ID查询购物车
	public ArrayList<cartBean> getcartBybuyerID(String buyerID) {
		
		DBAccess da = new DBAccess();
		da.getConn();
		ArrayList<cartBean> list = new ArrayList<cartBean>();
		String sql = "select * from cart where 购买者用户名='" + buyerID + "'";
		ResultSet rs = da.query(sql);
		try {
			while (rs.next()){
				cartBean buyer = new cartBean();
				buyer.setBuyerName(rs.getString("购买者用户名"));
				buyer.setBuyType(rs.getString("购买状态"));
				buyer.setCartId(rs.getInt("购物编号"));
				buyer.setGoodsDiscription(rs.getString("简述"));
				buyer.setGoodsId(rs.getInt("货物编号"));
				buyer.setGoodsName(rs.getString("货物名称"));
				buyer.setGoodsPrice(rs.getString("价格"));
				buyer.setGoodsType(rs.getString("货物类型"));
				buyer.setSellerContact(rs.getString("出售者联系方式"));
				buyer.setSellerName(rs.getString("出售者用户名"));
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
	//按照出售者ID查询订单
public ArrayList<cartBean> getcartBysellerID(String sellerID) {
		
		DBAccess da = new DBAccess();
		da.getConn();
		ArrayList<cartBean> list = new ArrayList<cartBean>();
		String sql = "select * from cart where 出售者用户名='" + sellerID + "'";
		ResultSet rs = da.query(sql);
		try {
			while (rs.next()){
				cartBean buyer = new cartBean();
				buyer.setBuyerName(rs.getString("购买者用户名"));
				buyer.setBuyType(rs.getString("购买状态"));
				buyer.setCartId(rs.getInt("购物编号"));
				buyer.setGoodsDiscription(rs.getString("简述"));
				buyer.setGoodsId(rs.getInt("货物编号"));
				buyer.setGoodsName(rs.getString("货物名称"));
				buyer.setGoodsPrice(rs.getString("价格"));
				buyer.setGoodsType(rs.getString("货物类型"));
				buyer.setSellerContact(rs.getString("出售者联系方式"));
				buyer.setSellerName(rs.getString("出售者用户名"));
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
//购物车物品数量
public int	getnumberbybuyerID(String sellerID){
	int number=0;
	DBAccess da = new DBAccess();
	da.getConn();
	String sql = "select count(*) from cart where 购买者用户名='"+sellerID+"'";

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
//用户重复商品检验
public int	getchongfu(String buyerId,int goodsId){
	int number=0;
	DBAccess da = new DBAccess();
	da.getConn();
	String sql = "select count(*) from cart where 购买者用户名='"+buyerId+"' and 货物编号="+goodsId;
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
//添加到购物车
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

			String sql = "delete from cart where  购物编号=" + cartid;
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
