package club.jc4u.xzkt.serviceImpl;


import club.jc4u.xzkt.entity.LoginLog;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.mapper.LoginLogMapper;
import club.jc4u.xzkt.service.LoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class LoginLogServiceImpl implements LoginLogService {

	@Resource
	private LoginLogMapper loginLogMapper;

	private ResponseForm res;

	@Override
	public ResponseForm getLastLog(String user_id) {
		res = new ResponseForm();
		if (user_id != null) {
			LoginLog loginLog = loginLogMapper.selLastLogByUserId(user_id);
			res.setContent(loginLog);
			res.setStatus(true);
		} else res.setError("查询失败");
		return res;
	}

	@Override
	public ResponseForm getAllLog() {
		res = new ResponseForm();
		List<LoginLog> loginLogs = loginLogMapper.selAll();
		if(loginLogs!=null) {
			res.setContent(loginLogs);
			res.setStatus(true);
		} else res.setError("获取日志失败");
		return res;
	}

	@Override
	public ResponseForm getNumOfLogin(String id) {
		res = new ResponseForm();
		if(id!=null){
			int result = loginLogMapper.selCountById(id);
			res.setContent(result);
			res.setStatus(true);
		}
		return res;
	}

	@Override
	public ResponseForm getAllLogById(String userId) {
		res = new ResponseForm();
		if(userId!=null){
			List<LoginLog> loginLogs = loginLogMapper.selAllById(userId);
			if(loginLogs!=null){
				res.setStatus(true);
				res.setContent(loginLogs);
			} else res.setError("获取个人全部日志失败");
		}
		return res;
	}

	@Override
	public ResponseForm addLog(LoginLog log) {
		res = new ResponseForm();
		if(log!=null){
			int result = loginLogMapper.insNewLog(log);
			if(result!=0){
				res.setContent(result);
				res.setStatus(true);
			} else res.setError("删除失败");
		} else res.setError("添加失败");
		return res;
	}

	@Override
	public ResponseForm delLog(LoginLog log) {
		res = new ResponseForm();
		if(log!=null){
			int result = loginLogMapper.delLogByStuNumAndTime(log);
			if(result!=0){
				res.setContent(result);
				res.setStatus(true);
			} else res.setError("删除数据失败");
		} else res.setError("删除失败");
		return res;
	}
}
