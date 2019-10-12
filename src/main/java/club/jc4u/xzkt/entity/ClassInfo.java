package club.jc4u.xzkt.entity;

public class ClassInfo {

	private int id;
	private String name;
	private String teacher;
	private String semester;
	private String length;
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

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

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "ClassInfo{" +
				"id=" + id +
				", name='" + name + '\'' +
				", teacher='" + teacher + '\'' +
				", semester='" + semester + '\'' +
				", length='" + length + '\'' +
				", status=" + status +
				'}';
	}
}
