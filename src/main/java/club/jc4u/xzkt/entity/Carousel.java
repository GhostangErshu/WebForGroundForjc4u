package club.jc4u.xzkt.entity;

public class Carousel {
	private int id;
	private String title;
	private String content;
	private String picLink;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicLink() {
		return picLink;
	}

	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}

	@Override
	public String toString() {
		return "Carousel [id=" + id + ", title=" + title + ", content=" + content + ", picLink=" + picLink + "]";
	}
}
