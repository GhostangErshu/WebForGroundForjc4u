package club.jc4u.xzkt.entity;

public class Video {
	private int id;
	private String video_id;
	private String title;
	private String time;
	private int viewNum;
	private String picLink;
	private String videoLink;

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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getViewNum() {
		return viewNum;
	}

	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}

	public String getPicLink() {
		return picLink;
	}

	public void setPicLink(String picLink) {
		this.picLink = picLink;
	}

	public String getVideoLink() {
		return videoLink;
	}

	public void setVideoLink(String videoLink) {
		this.videoLink = videoLink;
	}

	public String getVideo_id() {
		return video_id;
	}

	public void setVideo_id(String video_id) {
		this.video_id = video_id;
	}


	@Override
	public String toString() {
		return "Video{" +
				"id=" + id +
				", title='" + title + '\'' +
				", time='" + time + '\'' +
				", viewNum=" + viewNum +
				", picLink='" + picLink + '\'' +
				", videoLink='" + videoLink + '\'' +
				'}';
	}
}
