package com.jc4u.test;

import java.io.UnsupportedEncodingException;
import javax.mail.MessagingException;

import com.jc4u.mail.SendVerificationCodeEmail;

public class TestMail {
	public static void main(String[] args) throws MessagingException, UnsupportedEncodingException {
		new SendVerificationCodeEmail("a2576445561@qq.com", "4578").send();
	}
}
