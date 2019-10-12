package club.jc4u.xzkt.entity;

/**
 * @Author TangXi
 * @Date 19-9-24 下午4:04
 */
public class WhitePage {
	private int id;
	private String URI;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getURI() {
		return URI;
	}

	public void setURI(String URI) {
		this.URI = URI;
	}

	@Override
	public String toString() {
		return "whitePage{" +
				"id=" + id +
				", URI='" + URI + '\'' +
				'}';
	}
}
