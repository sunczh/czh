package myclass.bll;

import myclass.dal.userDal;

public class goodsBll {
	//������Ʒ��֤
	public String addgoodsyanzheng(String goodsName, String oldOrnew,String goodsprice,String contact,String goodstype,String discription) {
		String result = "";
		if(goodsName.equals("")||goodsName.equals("��Ʒ����")||goodsName.length()>=50){
			result =result+"��������ȷ����Ʒ���ƣ���Ҫ����50���ַ���;";
		}
		if(oldOrnew.equals("")||oldOrnew.equals("�¾ɳ̶�")){
			result =result+"��������ȷ���¾ɳ̶ȣ����ܳ���10���ַ���;";
		}
		if(goodsprice.equals("")||goodsprice.equals("�۸�")){
			result =result+"����������ȷ����Ʒ�۸񣨲��ܳ���10���ַ���;";
		}
		if(contact.equals("")||contact.equals("��ϵ��ʽ���ֻ�����QQ��")){
			result =result+"��������ȷ����ϵ��ʽ�����ܳ���50���ַ���;";
		}
		if(goodstype.equals("")||goodstype.equals(null)){
			result =result+"��ѡ����ȷ����Ʒ����;";
		}
		if(discription.equals("��Ʒ����")){
			result =result+"��������ȷ����Ʒ���ܣ����ܳ���50���ַ���";
		}
		return result;
	}
}
