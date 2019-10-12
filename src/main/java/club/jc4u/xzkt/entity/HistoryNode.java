package club.jc4u.xzkt.entity;

public class HistoryNode {
	private int id;
	private String title;
	private String author;
	private String time;

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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "HistoryNode{" +
				"id=" + id +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", time='" + time + '\'' +
				'}';
	}
}
