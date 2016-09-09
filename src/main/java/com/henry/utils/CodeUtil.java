package com.henry.utils;

import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Random;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

public class CodeUtil {
	
	private CodeUtil(){};
	
	/**
	 * 经过Base64产生24位的salt
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String generateSalt() throws UnsupportedEncodingException {
        Random RANDOM = new SecureRandom();
        byte[] salt = new byte[16];
        RANDOM.nextBytes(salt);//产生16个随机数
        String str = new String(salt,"UTF-8");
        Base64 base64 = new Base64();
        salt = base64.encode(salt);
        str = new String(salt);
		return str;
	}
	
	/**
	 *  pwd = SHA512 ( SHA512(pwd) + SALT)
	 * 
	 * @param password
	 * @return
	 */
	public static String encode(String password, String salt) {
		StringBuilder sb = new StringBuilder(password);
		sb.append(salt);
		return DigestUtils.sha512Hex(sb.toString());
	}
	
	/**
	 * 产生邮箱的激活码
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String createActiveCode(String email) throws UnsupportedEncodingException {
		String salt = generateSalt();
		StringBuilder sb = new StringBuilder(email);
		sb.append(salt);
		return DigestUtils.sha512Hex(sb.toString());
	}
}
