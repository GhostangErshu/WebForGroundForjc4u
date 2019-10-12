package club.jc4u.xzkt.serviceImpl;

import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.service.UtilService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class UtilServiceImpl implements UtilService {

	private String requestUrl = "http://www.jiahengfei.cn:33550/port/history?dispose=easy&key=jiahengfei";

	private ResponseForm res;

	@Override
	public ResponseForm getHistoryEvents(String month, String day){
		res = new ResponseForm();
		// 使用URL模拟浏览器访问，解决跨域访问
		URL url = null;
		URLConnection connect = null;
		BufferedReader reader = null;
		StringBuffer result = null;
		String line = null;
		try {
			url = new URL(requestUrl + "&month="+month+"&day="+day);
			connect = url.openConnection();
			reader = new BufferedReader(new InputStreamReader(connect.getInputStream()));
			result = new StringBuffer();
			while ((line = reader.readLine()) != null)
				result.append(line);
			reader.close();
		} catch (Exception e) {
			res.setError(e.getMessage());
		}
		res.setStatus(true);
		res.setContent(result);
		return res;
	}

}
