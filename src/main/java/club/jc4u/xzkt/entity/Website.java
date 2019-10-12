package club.jc4u.xzkt.entity;

public class Website {
	private int id;
	private String name;
	private String picLink;
	private String webLink;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPicLink() {
		return picLink;
	}

	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}

	public String getWebLink() {
		return webLink;
	}

	public void setWebLink(String webLink) {
		this.webLink = webLink;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Website(){}

	public Website(int id, String name, String picLink, String webLink) {
		super();
		this.id = id;
		this.name = name;
		this.picLink = picLink;
		this.webLink = webLink;
	}

	@Override
	public String toString() {
		return "Website{" +
				"id=" + id +
				", name='" + name + '\'' +
				", picLink='" + picLink + '\'' +
				", webLink='" + webLink + '\'' +
				'}';
	}
}
