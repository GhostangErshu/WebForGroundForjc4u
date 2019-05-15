package com.jc4u.entity;

public class Resource {
	private int id;
	private String name;
	private String contributor;
	private int visitNum;
	private String link;
	private String describe;
	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContributor() {
		return contributor;
	}

	public void setContributor(String contributor) {
		this.contributor = contributor;
	}

	public int getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(int visitNum) {
		this.visitNum = visitNum;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public Resource(int id, String name, String contributor, int visitNum, String link, String describe, String time) {
		super();
		this.id = id;
		this.name = name;
		this.contributor = contributor;
		this.visitNum = visitNum;
		this.link = link;
		this.describe = describe;
		this.time = time;
	}

	public Resource() {
	}

}
