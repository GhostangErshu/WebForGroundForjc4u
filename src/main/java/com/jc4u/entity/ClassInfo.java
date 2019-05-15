package com.jc4u.entity;

public class ClassInfo {
	private int id;
	private String name;
	private User teacher;

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

	public User getTeacher() {
		return teacher;
	}

	public void setTeacher(User teacher) {
		this.teacher = teacher;
	}

	public ClassInfo(int id, String name, User teacher) {
		this.id = id;
		this.name = name;
		this.teacher = teacher;
	}

	public ClassInfo() {
	}

}
