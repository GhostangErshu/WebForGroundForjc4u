package com.jc4u.entity;

public class Grade {
	private int id;
	private String name;
	private String time;
	private int grade;
	private String comment;

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Grade(int id, String name, String time, int grade, String comment) {
		this.id = id;
		this.name = name;
		this.time = time;
		this.grade = grade;
		this.comment = comment;
	}

	public Grade() {
	}

}
