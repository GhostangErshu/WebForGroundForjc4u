package club.jc4u.xzkt.entity;

public class Task {

	private int id;
	private String title;
	private String publisher;
	private String deadline;
	private String notes;
	private String fileLink;
	private String taskId;

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getFileLink() {
		return fileLink;
	}

	public void setFileLink(String fileLink) {
		this.fileLink = fileLink;
	}

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", title='" + title + '\'' +
				", publisher='" + publisher + '\'' +
				", deadline='" + deadline + '\'' +
				", notes='" + notes + '\'' +
				", fileLink='" + fileLink + '\'' +
				", taskId='" + taskId + '\'' +
				'}';
	}
}
