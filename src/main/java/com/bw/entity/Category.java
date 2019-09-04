package com.bw.entity;


public class Category implements java.io.Serializable {

	//columns START
	private Integer cid;
	private String cname;
	private String cdesc;
	//columns END
	public Category(){
	}
	public Category(Integer cid,String cname,String cdesc){
		this.cid=cid;		this.cname=cname;		this.cdesc=cdesc;	}

	public void setCid(Integer cid){
		this.cid=cid;
	}
	public Integer getCid(){
		return cid;
	}

	public void setCname(String cname){
		this.cname=cname;
	}
	public String getCname(){
		return cname;
	}

	public void setCdesc(String cdesc){
		this.cdesc=cdesc;
	}
	public String getCdesc(){
		return cdesc;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + ", cdesc=" + cdesc
				+ "]";
	}
	
	
}

