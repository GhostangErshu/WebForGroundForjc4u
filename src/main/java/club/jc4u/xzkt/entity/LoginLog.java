package club.jc4u.xzkt.entity;

public class LoginLog {

	private int id;
	private String name;
	private String time;
	private String ip;
	private String location;
	private String user_id;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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

	public LoginLog(String name, String time, String ip, String location, String user_id) {
		this.name = name;
		this.time = time;
		this.ip = ip;
		this.location = location;
		this.user_id = user_id;
	}

	public LoginLog() {
	}

	@Override
	public String toString() {
		return "LoginLog{" +
				"id=" + id +
				", name='" + name + '\'' +
				", time='" + time + '\'' +
				", ip='" + ip + '\'' +
				", location='" + location + '\'' +
				", user_id='" + user_id + '\'' +
				'}';
	}
}
