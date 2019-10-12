package club.jc4u.xzkt.entity;

public class Notice {
	private int id;
	private String notice_id;
	private String title;
	private String publisher;
	private String time;
	private int click;
	private String content;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNotice_id() {
		return notice_id;
	}

	public void setNotice_id(String notice_id) {
		this.notice_id = notice_id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClick() {
		return click;
	}

	public void setClick(int click) {
		this.click = click;
	}

	public Notice(int id, String title, String publisher, String time, int click, String content) {
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.time = time;
		this.click = click;
		this.content = content;
	}

	public Notice() {
	}

	@Override
	public String toString() {
		return "Notice{" +
				"id=" + id +
				", notice_id='" + notice_id + '\'' +
				", title='" + title + '\'' +
				", publisher='" + publisher + '\'' +
				", time='" + time + '\'' +
				", click=" + click +
				", content='" + content + '\'' +
				'}';
	}
}
