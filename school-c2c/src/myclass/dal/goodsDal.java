package myclass.dal;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import myclass.bol.goodsInfo;
//查询所有商品
public class goodsDal {
	public ArrayList<goodsInfo> getgoodsAll() {
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from huowu ORDER BY 货物编号 DESC";
		ResultSet rs = da.query(sql);
		ArrayList<goodsInfo> list = new ArrayList<goodsInfo>();
		try {
			while (rs.next()) {
				goodsInfo bi = new goodsInfo();
				bi.setGoodsId(rs.getInt("货物编号"));
				bi.setGoodsName(rs.getString("货物名称"));
				bi.setOldornew(rs.getString("新旧程度"));
				bi.setUserName(rs.getString("出售者联系方式"));
				bi.setShangjiaDate(rs.getString("上架日期"));
				bi.setDescription(rs.getString("物品简述"));
				bi.setContact(rs.getString("出售者联系方式"));
				bi.setGoodstype(rs.getString("货物类型"));
				bi.setPrice(rs.getString("价格"));
				bi.setPictureAddress(rs.getString("图片地址"));
				list.add(bi);
			}
		} catch (SQLException e) {
			System.out.println("报错");
			return null;
		} finally {
			da.closeConnection();
		}
		return list;
	}
	//显示最新商品
	public ArrayList<goodsInfo> getgoodsNew() {
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from huowu ORDER BY 货物编号 DESC";
		ResultSet rs = da.query(sql);
		ArrayList<goodsInfo> list = new ArrayList<goodsInfo>();
		try {int i=0;
			while (rs.next()&&i<=6) {
				i++;
				goodsInfo bi = new goodsInfo();
				bi.setGoodsId(rs.getInt("货物编号"));
				bi.setUserName(rs.getString("出售者用户名"));
				bi.setGoodsName(rs.getString("货物名称"));
				bi.setOldornew(rs.getString("新旧程度"));
				bi.setShangjiaDate(rs.getString("上架日期"));
				bi.setDescription(rs.getString("物品简述"));
				bi.setContact(rs.getString("出售者联系方式"));
				bi.setGoodstype(rs.getString("货物类型"));
				bi.setPrice(rs.getString("价格"));
				bi.setPictureAddress(rs.getString("图片地址"));
				list.add(bi);
			}
		} catch (SQLException e) {
			System.out.println("报错");
			return null;
		} finally {
			da.closeConnection();
		}
		return list;
	}
	
//按类型查询商品
	public ArrayList<goodsInfo> getgoodsAstype(String goodstype) {
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from huowu where 货物类型='"+goodstype+"' ORDER BY 货物编号 DESC";
		ResultSet rs = da.query(sql);
		System.out.println(sql);
		ArrayList<goodsInfo> list = new ArrayList<goodsInfo>();
		try {
			while (rs.next()) {
				goodsInfo bi = new goodsInfo();
				bi.setGoodsId(rs.getInt("货物编号"));
				bi.setGoodsName(rs.getString("货物名称"));
				bi.setOldornew(rs.getString("新旧程度"));
				bi.setUserName(rs.getString("出售者用户名"));
				bi.setShangjiaDate(rs.getString("上架日期"));
				bi.setDescription(rs.getString("物品简述"));
				bi.setContact(rs.getString("出售者联系方式"));
				bi.setGoodstype(rs.getString("货物类型"));
				bi.setPrice(rs.getString("价格"));
				bi.setPictureAddress(rs.getString("图片地址"));
				list.add(bi);
			}
		} catch (SQLException e) {
			System.out.println("报错");
			return null;
		} finally {
			da.closeConnection();
		}
		return list;
	}
	//按类型查询商品
		public goodsInfo getgoodsId(String goodsId) {
			DBAccess da = new DBAccess();
			da.getConn();
			String sql = "select * from huowu where 货物编号="+goodsId;
			System.out.println(sql);
			ResultSet rs = da.query(sql);
			goodsInfo bi = new goodsInfo();
			try {
				if (rs.next()) {
					bi.setGoodsId(rs.getInt("货物编号"));
					bi.setGoodsName(rs.getString("货物名称"));
					bi.setOldornew(rs.getString("新旧程度"));
					bi.setUserName(rs.getString("出售者用户名"));
					bi.setShangjiaDate(rs.getString("上架日期"));
					bi.setDescription(rs.getString("物品简述"));
					bi.setContact(rs.getString("出售者联系方式"));
					bi.setGoodstype(rs.getString("货物类型"));
					bi.setPrice(rs.getString("价格"));
					bi.setPictureAddress(rs.getString("图片地址"));
				}
			} catch (SQLException e) {
				System.out.println("报错");
				return null;
			} finally {
				da.closeConnection();
			}
			return bi;
		}
	//转换
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
	
	//增加商品
	public int addGoods(String goodsName, String oldOrnew,String shangjiaDate,String discription,
			String userName,String contact,String other,String picturesAddress,String goodsprice,String goodstype)
	{
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "insert into huowu values('" + goodsName + "','"
				+ oldOrnew + "','" + shangjiaDate + "','" + discription + "','"+userName+"','"+contact+"','"+other+"','"+picturesAddress+"','"+goodsprice+"','"+goodstype+"')";
	
		int r= da.executeSql(sql);
		da.closeConnection();
		return r;
	}
	
}
