package club.jc4u.xzkt.entity;

public class Semester {
	private int id;
	private String semester_nickname;
	private String semester_name;
	private String semester_time;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSemester_nickname() {
		return semester_nickname;
	}

	public void setSemester_nickname(String semester_nickname) {
		this.semester_nickname = semester_nickname;
	}

	public String getSemester_name() {
		return semester_name;
	}

	public void setSemester_name(String semester_name) {
		this.semester_name = semester_name;
	}

	public String getSemester_time() {
		return semester_time;
	}

	public void setSemester_time(String semester_time) {
		this.semester_time = semester_time;
	}

}
