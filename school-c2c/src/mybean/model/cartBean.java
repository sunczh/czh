package mybean.model;

public class cartBean {
	//������
	private int cartId;
	//������
	private int goodsId;
	//��������
	private String goodsName=null;
	//�������û���
	private String sellerName=null;
	//��������ϵ��ʽ
	private String sellerContact=null;
	//����������
	private String buyerName=null;
	//����۸�
	private String goodsPrice=null;
	//��������
	private String goodsType=null;
	//��������
	private String goodsDiscription=null;
	//����״̬
	private String buyType=null;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerContact() {
		return sellerContact;
	}
	public void setSellerContact(String sellerContact) {
		this.sellerContact = sellerContact;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	public String getGoodsDiscription() {
		return goodsDiscription;
	}
	public void setGoodsDiscription(String goodsDiscription) {
		this.goodsDiscription = goodsDiscription;
	}
	public String getBuyType() {
		return buyType;
	}
	public void setBuyType(String buyType) {
		this.buyType = buyType;
	}
	
}
