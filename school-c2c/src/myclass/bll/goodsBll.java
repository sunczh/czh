package myclass.bll;

import myclass.dal.userDal;

public class goodsBll {
	//增加商品验证
	public String addgoodsyanzheng(String goodsName, String oldOrnew,String goodsprice,String contact,String goodstype,String discription) {
		String result = "";
		if(goodsName.equals("")||goodsName.equals("物品名称")||goodsName.length()>=50){
			result =result+"请输入正确的物品名称（不要超过50个字符）;";
		}
		if(oldOrnew.equals("")||oldOrnew.equals("新旧程度")){
			result =result+"请输入正确的新旧程度（不能超过10个字符）;";
		}
		if(goodsprice.equals("")||goodsprice.equals("价格")){
			result =result+"请输入如正确的物品价格（不能超过10个字符）;";
		}
		if(contact.equals("")||contact.equals("联系方式（手机或者QQ）")){
			result =result+"请输入正确的联系方式（不能超过50个字符）;";
		}
		if(goodstype.equals("")||goodstype.equals(null)){
			result =result+"请选择正确的物品类型;";
		}
		if(discription.equals("物品介绍")){
			result =result+"请输入正确的物品介绍（不能超过50个字符）";
		}
		return result;
	}
}
