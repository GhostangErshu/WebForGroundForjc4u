package club.jc4u.xzkt.entity;

import java.util.ArrayList;

public class ImgDataForEditor {
	
	private int errno;
	private ArrayList<String> data = new ArrayList<>();

	public int getErrno() {
		return errno;
	}

	public void setErrno(int errno) {
		this.errno = errno;
	}

	public ArrayList<String> getData() {
		return data;
	}

	public void setData(ArrayList<String> data) {
		this.data = data;
	}
	

}
