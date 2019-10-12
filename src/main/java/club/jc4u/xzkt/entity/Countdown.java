package club.jc4u.xzkt.entity;

public class Countdown {
	private int id;
	private String thing;
	private String time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getThing() {
		return thing;
	}

	public void getThing(String thing) {
		this.thing = thing;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Countdown(int id, String thing, String time) {
		super();
		this.id = id;
		this.thing = thing;
		this.time = time;
	}

}
