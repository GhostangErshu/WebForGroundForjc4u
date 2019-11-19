package club.jc4u.xzkt.entity;


/**
 * @Author TangXi
 * @Date 19-11-3 下午2:03
 */
public class IpLocation {
	private int code;
	private IpDetail data;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public IpDetail getData() {
		return data;
	}

	public void setData(IpDetail data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "IpLocation{" +
				"code=" + code +
				", data=" + data +
				'}';
	}
}
