package club.jc4u.xzkt.entity;

public class Suggestion {

	private int id;
	private String name;
	private String content;
	private String time;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Suggestion(String name, String content, String time) {
		this.name = name;
		this.content = content;
		this.time = time;
	}

	public Suggestion() {
	}

	@Override
	public String toString() {
		return "Suggestion{" +
				"id=" + id +
				", name='" + name + '\'' +
				", content='" + content + '\'' +
				", time='" + time + '\'' +
				'}';
	}
}
