package club.jc4u.xzkt.interceptor;

/**
 * @Author TangXi
 * @Date 19-10-12 下午12:21
 */
public class test {
	public static void main(String[] args) {
//		int result = f(2,3);
//		System.out.println(result);
		f(2,3);
	}

	static void f(int a,int b){
		if(a>=b)
			System.out.println(a);
//			return;
		else
//			return b;
			System.out.println(b);
	}
}
