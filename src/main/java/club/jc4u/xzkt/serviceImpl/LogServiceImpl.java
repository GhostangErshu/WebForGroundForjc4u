package club.jc4u.xzkt.serviceImpl;

import club.jc4u.xzkt.entity.Log;
import club.jc4u.xzkt.entity.ResponseForm;
import club.jc4u.xzkt.mapper.LogMapper;
import club.jc4u.xzkt.mapper.UserMapper;
import club.jc4u.xzkt.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author TangXi
 * @Date 19-11-19 下午2:16
 */
@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private LogMapper logMapper;
	@Autowired
	private UserMapper userMapper;

	ResponseForm res = null;

	@Override
	public ResponseForm add(Log log) {
		res = new ResponseForm();
		//设置此时的时间
		log.setTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
		int result = logMapper.addLog(log);
		if(result>0){
			res.setStatus(true);
		} else res.setError("添加失败");
		return res;
	}

	@Override
	public ResponseForm del(Log log) {
		res = new ResponseForm();
		//通过传过来的时间进行删除
		if(Objects.isNull(log.getTime())){
			res.setError("参数错误");
			return res;
		}
		int result = logMapper.delLog(log);
		if(result<0)
			res.setError("删除失败或无可删除项");
		else
			res.setStatus(true);
		return res;
	}

	@Override
	public ResponseForm list() {
		res = new ResponseForm();
		List<Log> logs = logMapper.listAllLog();
		if(logs!=null){
			for(Log e:logs){
				//设置姓名
				e.setTemp(userMapper.selUserById(e.getPerson()).getName());
			}
			res.setContent(logs);
			res.setStatus(true);
		} else res.setError("查询失败");
		return res;
	}
}