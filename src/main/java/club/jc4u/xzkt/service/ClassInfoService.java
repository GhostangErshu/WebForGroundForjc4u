package club.jc4u.xzkt.service;

import club.jc4u.xzkt.entity.ClassInfo;
import club.jc4u.xzkt.entity.ResponseForm;


public interface ClassInfoService {

	ResponseForm getUserRealtimeClassInfoById(String id);

	ResponseForm getUserAllClassInfoById(String id);

	ResponseForm getAllClassInfo();

	ResponseForm updateClassStatus(ClassInfo e);

	ResponseForm addNewClass(ClassInfo e);

	ResponseForm getAllActiveClass();

}
