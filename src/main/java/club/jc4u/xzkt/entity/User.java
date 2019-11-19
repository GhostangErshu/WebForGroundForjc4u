package club.jc4u.xzkt.entity;

public class User {

	private int id;
	private String stuNum;
	private String name;
	private String password;
	private int status;
	private String email;
	private String head;
	private String sign;
	private String temp;
	private int powerLevel;

	public int getPowerLevel() {
		return powerLevel;
	}

	public void setPowerLevel(int powerLevel) {
		this.powerLevel = powerLevel;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
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

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}


	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public User(String stuNum, String password) {
		this.stuNum = stuNum;
		this.password = password;
	}

	public User() {
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", stuNum='" + stuNum + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", status=" + status +
				", email='" + email + '\'' +
				", head='" + head + '\'' +
				", sign='" + sign + '\'' +
				", temp='" + temp + '\'' +
				", powerLevel=" + powerLevel +
				'}';
	}
}
