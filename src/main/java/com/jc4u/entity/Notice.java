package com.jc4u.entity;

public class Notice {
	private int id;
	private String title;
	private String publisher;
	private String time;
	private int visitNum;
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getVisitNum() {
		return visitNum;
	}

	public void setVisitNum(int visitNum) {
		this.visitNum = visitNum;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Notice(int id, String title, String publisher, String time, int visitNum, String content) {
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.time = time;
		this.visitNum = visitNum;
		this.content = content;
	}

	public Notice() {
	}

}
