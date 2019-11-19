package club.jc4u.xzkt.service;

import club.jc4u.xzkt.entity.LoginLog;
import club.jc4u.xzkt.entity.ResponseForm;



public interface LoginLogService {
	
	ResponseForm getLastLog(String user_id);

	ResponseForm getAllLog();

	ResponseForm getAllLogById(String userId);

	ResponseForm getNumOfLogin(String id);

	ResponseForm addLog(LoginLog log);

	ResponseForm delLog(LoginLog log);
}
