package club.jc4u.xzkt.service;

import club.jc4u.xzkt.entity.ResponseForm;

import java.io.IOException;

public interface UtilService {

	ResponseForm getHistoryEvents(String month, String day) throws IOException;
}
