package club.jc4u.xzkt.utils;

public class MathUtil {
	/**
	 * 随机生成一串数字
	 * @param length
	 * @return
	 */
	public static String getRandomNums(int length) {
		//首先创建一个动态字符串对象
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < length; i++) {
			//随机生成一个数字
			int temp = (int) (Math.random()*100%10);
			result.append(temp);
		}
		return result.toString();
	}

	private MathUtil(){}
}
