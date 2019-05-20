package com.jc4u.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 * 邮箱验证
 * @author ERSHU
 * @version 1.0
 *
 */
public class Authentication extends Authenticator {
	private String username = null;
	private String password = null;

	public Authentication() {

	}

	public Authentication(String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
	}

}
