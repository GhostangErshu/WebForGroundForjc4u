package club.jc4u.xzkt.utils;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

import club.jc4u.xzkt.entity.Task;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;

public class TokenUtil {
	/**
	 * token过期的时间2hour
	 */
	private static final long EXPIRE_TIME = 1000 * 60 * 60 * 12;
	/**
	 * token的秘钥
	 */
	private static final String TOKEN_SECRET = "42ce36456794380d6417d862fd9dbb6d";

	/**
	 * 实现签名方法,生成token
	 *
	 * @throws UnsupportedEncodingException
	 * @throws IllegalArgumentException
	 * @author TangXi
	 */
	public static String sign(String powerLevel, String userId) throws IllegalArgumentException, UnsupportedEncodingException {
		Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
		// 加密及加密算法
		Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
		// 设置头部信息
		HashMap<String, Object> header = new HashMap<>(2);
		header.put("typ", "JWT");
		header.put("alg", "HS256");
		// 对传过来的用户信息进行加密，生成签名
		return JWT.create().withHeader(header)
				.withClaim("powerLevel", powerLevel)
				.withClaim("userId", userId)
				.withExpiresAt(date)
				.sign(algorithm);
	}

	/**
	 * 对token进行验证
	 *
	 * @param token
	 * @return boolean status
	 */
	public static boolean verify(String token) {
		JWTVerifier verifier = null;
		try {
			verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build();
			verifier.verify(token);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public static String getPowerLevel(String token) {
		return getClaim(token,"powerLevel");
	}

	public static String getUserId(String token) {
		return getClaim(token,"userId");
	}

	//获取claim
	private static String getClaim(String token, String Claim) {
		Claim claim = null;
		try {
			claim = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token).getClaim(Claim);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return claim.asString();
	}

	//禁止实例化
	private TokenUtil() {
	}

}