package mybean.model;

public class cartBean {
	//购物编号
	private int cartId;
	//货物编号
	private int goodsId;
	//货物名称
	private String goodsName=null;
	//出售者用户名
	private String sellerName=null;
	//出售者联系方式
	private String sellerContact=null;
	//购买者姓名
	private String buyerName=null;
	//货物价格
	private String goodsPrice=null;
	//货物种类
	private String goodsType=null;
	//货物描述
	private String goodsDiscription=null;
	//购买状态
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
