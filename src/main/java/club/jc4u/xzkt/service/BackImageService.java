package club.jc4u.xzkt.service;

import club.jc4u.xzkt.entity.BackgroundImg;
import club.jc4u.xzkt.entity.ResponseForm;

import java.util.List;

public interface BackImageService {

	ResponseForm getAllBackImages();

	ResponseForm getRandomOne();
}
