package com.jc4u.entity;

public class User {
	@Override
	public String toString() {
		return "User [id=" + id + ", stunum=" + stunum + ", name=" + name + ", password=" + password + ", status="
				+ status + "]";
	}

	private int id;
	private String stunum;
	private String name;
	private String password;
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStunum() {
		return stunum;
	}

	public void setStunum(String stunum) {
		this.stunum = stunum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User(int id, String stunum, String name, String password, int status) {
		this.id = id;
		this.stunum = stunum;
		this.name = name;
		this.password = password;
		this.status = status;
	}

	public User() {

	}
}
