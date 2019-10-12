package club.jc4u.xzkt.service;

import club.jc4u.xzkt.entity.ResponseForm;


public interface ClassInfoService {

	ResponseForm getUserRealtimeClassInfoById(String id);

	ResponseForm getUserAllClassInfoById(String id);
}
