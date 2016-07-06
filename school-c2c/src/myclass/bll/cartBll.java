package myclass.bll;

import mybean.model.cartBean;
import myclass.bol.goodsInfo;
import myclass.dal.cartDal;

public class cartBll {
//添加到购物车
	public String addshoppingcart(String buyerName,goodsInfo goods,String buyType){
		String jieguo="";

		cartDal cd=new cartDal();
		int i=cd.getchongfu(buyerName, goods.getGoodsId());
		if(buyerName.equals("")||buyerName.equals(null)){
			jieguo=jieguo+"请登录;";
		}
		if(buyType.equals("")||buyType.equals(null)){
			jieguo=jieguo+"商品状态不正确;";
		}
		if(goods.getGoodsId()==0){
			jieguo=jieguo+"商品编号不正确;";
		}
		if(goods.getGoodsName().equals("")||goods.getGoodsName().equals(null)){
			jieguo=jieguo+"商品名称不正确;";
		}
		if(i!=0){
			jieguo=jieguo+"购物车已有该商品";
		}
		if(jieguo.equals("")){
			cd.addCart(buyerName, goods, buyType);
		}
		return jieguo;
	}
	public String deleteshoppingcartbyid(String cartid){
		String jieguo="删除失败";
		
		try {
			int newcartid=Integer.parseInt(cartid);
			cartDal cd=new cartDal();
			
			if(cd.deletecartbyid(newcartid)>0){
				jieguo="";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return jieguo;
	}
}
