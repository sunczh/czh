package myclass.bol;

public class goodsInfo {
	//货物编号
	private int goodsId;
	//货物名称
	private String goodsName=null;
	//价格
	private String price=null;
	//货物类型
	private String goodstype=null;
	//出售者用户名
	private String userName=null;
	//新旧程度
	private String oldornew=null;
	//上架日期
	private String shangjiaDate=null;
	//物品简述
	private String description=null;
	//出售者联系方式
	private String contact=null;
	//备注
	private String others=null;
	//图片地址
	private String pictureAddress=null;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOldornew() {
		return oldornew;
	}
	public void setOldornew(String oldornew) {
		this.oldornew = oldornew;
	}
	public String getShangjiaDate() {
		return shangjiaDate;
	}
	public void setShangjiaDate(String shangjiaDate) {
		this.shangjiaDate = shangjiaDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	public String getPictureAddress() {
		return pictureAddress;
	}
	public void setPictureAddress(String pictureAddress) {
		this.pictureAddress = pictureAddress;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGoodstype() {
		return goodstype;
	}
	public void setGoodstype(String goodstype) {
		this.goodstype = goodstype;
	}

	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
}
