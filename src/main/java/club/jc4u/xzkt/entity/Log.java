package club.jc4u.xzkt.entity;

/**
 * @Author TangXi
 * @Date 19-11-19 下午2:02
 */
public class Log {
	private int id;
	private String person;
	private String time;
	private String content;
	private String temp;

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Log{" +
				"id=" + id +
				", person='" + person + '\'' +
				", time='" + time + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}
