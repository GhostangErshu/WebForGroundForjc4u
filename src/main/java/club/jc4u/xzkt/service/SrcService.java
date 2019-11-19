package club.jc4u.xzkt.service;

import club.jc4u.xzkt.entity.ResponseForm;

public interface SrcService {

	ResponseForm getAllDownloadInfo();

	ResponseForm getDetailInfo(String id);

	ResponseForm increseVisitNum(String id);
}
