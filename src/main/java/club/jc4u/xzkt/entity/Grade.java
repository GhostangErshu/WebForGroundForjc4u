package club.jc4u.xzkt.entity;

public class Grade implements Comparable<Grade> {
	private int id;
	private int grade;
	private int status;
	private int classId;
	private String name;
	private String stuNum;
	private String time_submit;
	private String time_correct;
	private String comment;
	private String taskId;
	private String corrector;
	private String content;
	private String taskFileLink;
	private String temp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStuNum() {
		return stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getTime_submit() {
		return time_submit;
	}

	public void setTime_submit(String time_submit) {
		this.time_submit = time_submit;
	}

	public String getTime_correct() {
		return time_correct;
	}

	public void setTime_correct(String time_correct) {
		this.time_correct = time_correct;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getCorrector() {
		return corrector;
	}

	public void setCorrector(String corrector) {
		this.corrector = corrector;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTaskFileLink() {
		return taskFileLink;
	}

	public void setTaskFileLink(String taskFileLink) {
		this.taskFileLink = taskFileLink;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	@Override
	public int compareTo(Grade o) {
		if (this.grade > o.grade)
			return -1;
		else if (this.grade < o.grade)
			return 1;
		return 0;
	}

	@Override
	public String toString() {
		return "Grade{" +
				"id=" + id +
				", grade=" + grade +
				", status=" + status +
				", classId=" + classId +
				", name='" + name + '\'' +
				", stuNum='" + stuNum + '\'' +
				", time_submit='" + time_submit + '\'' +
				", time_correct='" + time_correct + '\'' +
				", comment='" + comment + '\'' +
				", taskId='" + taskId + '\'' +
				", corrector='" + corrector + '\'' +
				", content='" + content + '\'' +
				", taskFileLink='" + taskFileLink + '\'' +
				", temp='" + temp + '\'' +
				'}';
	}
}
