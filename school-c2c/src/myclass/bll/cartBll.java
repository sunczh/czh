package myclass.bll;

import mybean.model.cartBean;
import myclass.bol.goodsInfo;
import myclass.dal.cartDal;

public class cartBll {
//��ӵ����ﳵ
	public String addshoppingcart(String buyerName,goodsInfo goods,String buyType){
		String jieguo="";

		cartDal cd=new cartDal();
		int i=cd.getchongfu(buyerName, goods.getGoodsId());
		if(buyerName.equals("")||buyerName.equals(null)){
			jieguo=jieguo+"���¼;";
		}
		if(buyType.equals("")||buyType.equals(null)){
			jieguo=jieguo+"��Ʒ״̬����ȷ;";
		}
		if(goods.getGoodsId()==0){
			jieguo=jieguo+"��Ʒ��Ų���ȷ;";
		}
		if(goods.getGoodsName().equals("")||goods.getGoodsName().equals(null)){
			jieguo=jieguo+"��Ʒ���Ʋ���ȷ;";
		}
		if(i!=0){
			jieguo=jieguo+"���ﳵ���и���Ʒ";
		}
		if(jieguo.equals("")){
			cd.addCart(buyerName, goods, buyType);
		}
		return jieguo;
	}
	public String deleteshoppingcartbyid(String cartid){
		String jieguo="ɾ��ʧ��";
		
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
