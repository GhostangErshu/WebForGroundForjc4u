package club.jc4u.xzkt.service;

import club.jc4u.xzkt.entity.Log;
import club.jc4u.xzkt.entity.ResponseForm;

/**
 * @Author TangXi
 * @Date 19-11-19 下午2:14
 */
public interface LogService {
	ResponseForm add(Log log);

	ResponseForm del(Log log);

	ResponseForm list();
}
