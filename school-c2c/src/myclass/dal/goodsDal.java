package myclass.dal;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import myclass.bol.goodsInfo;
//��ѯ������Ʒ
public class goodsDal {
	public ArrayList<goodsInfo> getgoodsAll() {
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from huowu ORDER BY ������ DESC";
		ResultSet rs = da.query(sql);
		ArrayList<goodsInfo> list = new ArrayList<goodsInfo>();
		try {
			while (rs.next()) {
				goodsInfo bi = new goodsInfo();
				bi.setGoodsId(rs.getInt("������"));
				bi.setGoodsName(rs.getString("��������"));
				bi.setOldornew(rs.getString("�¾ɳ̶�"));
				bi.setUserName(rs.getString("��������ϵ��ʽ"));
				bi.setShangjiaDate(rs.getString("�ϼ�����"));
				bi.setDescription(rs.getString("��Ʒ����"));
				bi.setContact(rs.getString("��������ϵ��ʽ"));
				bi.setGoodstype(rs.getString("��������"));
				bi.setPrice(rs.getString("�۸�"));
				bi.setPictureAddress(rs.getString("ͼƬ��ַ"));
				list.add(bi);
			}
		} catch (SQLException e) {
			System.out.println("����");
			return null;
		} finally {
			da.closeConnection();
		}
		return list;
	}
	//��ʾ������Ʒ
	public ArrayList<goodsInfo> getgoodsNew() {
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from huowu ORDER BY ������ DESC";
		ResultSet rs = da.query(sql);
		ArrayList<goodsInfo> list = new ArrayList<goodsInfo>();
		try {int i=0;
			while (rs.next()&&i<=6) {
				i++;
				goodsInfo bi = new goodsInfo();
				bi.setGoodsId(rs.getInt("������"));
				bi.setUserName(rs.getString("�������û���"));
				bi.setGoodsName(rs.getString("��������"));
				bi.setOldornew(rs.getString("�¾ɳ̶�"));
				bi.setShangjiaDate(rs.getString("�ϼ�����"));
				bi.setDescription(rs.getString("��Ʒ����"));
				bi.setContact(rs.getString("��������ϵ��ʽ"));
				bi.setGoodstype(rs.getString("��������"));
				bi.setPrice(rs.getString("�۸�"));
				bi.setPictureAddress(rs.getString("ͼƬ��ַ"));
				list.add(bi);
			}
		} catch (SQLException e) {
			System.out.println("����");
			return null;
		} finally {
			da.closeConnection();
		}
		return list;
	}
	
//�����Ͳ�ѯ��Ʒ
	public ArrayList<goodsInfo> getgoodsAstype(String goodstype) {
		DBAccess da = new DBAccess();
		da.getConn();
		String sql = "select * from huowu where ��������='"+goodstype+"' ORDER BY ������ DESC";
		ResultSet rs = da.query(sql);
		System.out.println(sql);
		ArrayList<goodsInfo> list = new ArrayList<goodsInfo>();
		try {
			while (rs.next()) {
				goodsInfo bi = new goodsInfo();
				bi.setGoodsId(rs.getInt("������"));
				bi.setGoodsName(rs.getString("��������"));
				bi.setOldornew(rs.getString("�¾ɳ̶�"));
				bi.setUserName(rs.getString("�������û���"));
				bi.setShangjiaDate(rs.getString("�ϼ�����"));
				bi.setDescription(rs.getString("��Ʒ����"));
				bi.setContact(rs.getString("��������ϵ��ʽ"));
				bi.setGoodstype(rs.getString("��������"));
				bi.setPrice(rs.getString("�۸�"));
				bi.setPictureAddress(rs.getString("ͼƬ��ַ"));
				list.add(bi);
			}
		} catch (SQLException e) {
			System.out.println("����");
			return null;
		} finally {
			da.closeConnection();
		}
		return list;
	}
	//�����Ͳ�ѯ��Ʒ
		public goodsInfo getgoodsId(String goodsId) {
			DBAccess da = new DBAccess();
			da.getConn();
			String sql = "select * from huowu where ������="+goodsId;
			System.out.println(sql);
			ResultSet rs = da.query(sql);
			goodsInfo bi = new goodsInfo();
			try {
				if (rs.next()) {
					bi.setGoodsId(rs.getInt("������"));
					bi.setGoodsName(rs.getString("��������"));
					bi.setOldornew(rs.getString("�¾ɳ̶�"));
					bi.setUserName(rs.getString("�������û���"));
					bi.setShangjiaDate(rs.getString("�ϼ�����"));
					bi.setDescription(rs.getString("��Ʒ����"));
					bi.setContact(rs.getString("��������ϵ��ʽ"));
					bi.setGoodstype(rs.getString("��������"));
					bi.setPrice(rs.getString("�۸�"));
					bi.setPictureAddress(rs.getString("ͼƬ��ַ"));
				}
			} catch (SQLException e) {
				System.out.println("����");
				return null;
			} finally {
				da.closeConnection();
			}
			return bi;
		}
	//ת��
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
	
	//������Ʒ
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
