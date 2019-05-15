package com.jc4u.entity;

public class LoginLog {
	private int id;
	private String name;
	private String time;
	private String ip;
	private String location;

	public LoginLog(int id, String name, String time, String ip, String location) {
		this.id = id;
		this.name = name;
		this.time = time;
		this.ip = ip;
		this.location = location;
	}

	public LoginLog() {
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
