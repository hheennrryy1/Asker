package com.henry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.henry.entity.User;

@Service
public class MailService {
	
	private MailSender sender;
	
	@Autowired
	public void setSender(MailSender sender) {
		this.sender = sender;
	}

	public void sendMail(User user) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("363515287@qq.com");
		message.setTo(user.getEmail());
		message.setSubject("欢迎激活Asker帐号");
		StringBuilder sb = new StringBuilder(user.getUsername());
		sb.append(" 您好，感谢您注册Asker帐号")
			.append("\n")
			.append("请点击此链接以完成注册")
			.append("\n")
			.append("http://192.168.0.106/Asker/user/active/") //需要改
			.append(user.getId())
			.append("?activeCode=")
			.append(user.getActiveCode());
		message.setText(sb.toString());
		sender.send(message);
	}
}
