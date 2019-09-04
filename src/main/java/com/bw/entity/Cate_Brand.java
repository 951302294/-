package com.bw.entity;


public class Cate_Brand implements java.io.Serializable {

	//columns START
	private Integer id;
	private Integer cid;
	private Integer bid;
	//columns END
	public Cate_Brand(){
	}
	public Cate_Brand(Integer id,Integer cid,Integer bid){
		this.id=id;		this.cid=cid;		this.bid=bid;	}

	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
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
}

