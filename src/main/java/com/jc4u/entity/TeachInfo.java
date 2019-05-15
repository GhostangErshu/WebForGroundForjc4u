package com.jc4u.entity;

public class TeachInfo {
	private int id;
	private int userid;
	private int classid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getClassid() {
		return classid;
	}

	public void setClassid(int classid) {
		this.classid = classid;
	}

	public TeachInfo(int id, int userid, int classid) {
		this.id = id;
		this.userid = userid;
		this.classid = classid;
	}

	public TeachInfo() {

	}
}
