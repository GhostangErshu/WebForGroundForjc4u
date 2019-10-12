package club.jc4u.xzkt.entity;

public class TeacherInfo {
	private int id;
	private int userId;
	private int classId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	@Override
	public String toString() {
		return "TeacherInfo{" +
				"id=" + id +
				", userId=" + userId +
				", classId=" + classId +
				'}';
	}
}
