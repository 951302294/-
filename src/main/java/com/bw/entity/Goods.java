package com.bw.entity;


public class Goods implements java.io.Serializable {

	//columns START
	private Integer gid;
	private String gname;
	private String gdesc;
	private String price;
	private Integer cid;
	private Integer bid;
	
	
	private String bname;
	private String cname;
	//columns END
	public Goods(){
	}

	public void setGid(Integer gid){
		this.gid=gid;
	}
	public Integer getGid(){
		return gid;
	}

	public void setGname(String gname){
		this.gname=gname;
	}
	public String getGname(){
		return gname;
	}

	public void setGdesc(String gdesc){
		this.gdesc=gdesc;
	}
	public String getGdesc(){
		return gdesc;
	}

	public void setPrice(String price){
		this.price=price;
	}
	public String getPrice(){
		return price;
	}

	public void setCid(Integer cid){
		this.cid=cid;
	}
	public Integer getCid(){
		return cid;
	}

	public void setBid(Integer bid){
		this.bid=bid;
	}
	public Integer getBid(){
		return bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	
	public Goods(Integer gid, String gname, String gdesc, String price,
			Integer cid, Integer bid, String bname, String cname) {
		super();
		this.gid = gid;
		this.gname = gname;
		this.gdesc = gdesc;
		this.price = price;
		this.cid = cid;
		this.bid = bid;
		this.bname = bname;
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gdesc=" + gdesc
				+ ", price=" + price + ", cid=" + cid + ", bid=" + bid
				+ ", bname=" + bname + ", cname=" + cname + "]";
	}
	
	
}

