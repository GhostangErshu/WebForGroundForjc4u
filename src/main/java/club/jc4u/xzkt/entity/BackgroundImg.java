package club.jc4u.xzkt.entity;

public class BackgroundImg {

	private int id;
	private String url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "BackgroundImg{" +
				"id=" + id +
				", url='" + url + '\'' +
				'}';
	}
}
