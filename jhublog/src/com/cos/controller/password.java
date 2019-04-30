package com.cos.controller;

import com.cos.util.SHA256;

public class password {

	public static void main(String[] args) {
		
		String salt = SHA256.generateSalt();
		
		System.out.println(salt);

		String password1 = SHA256.getEncrypt("1234", salt);
		String password2 = SHA256.getEncrypt("123_4", salt);
		System.out.println(password1);
		System.out.println(password1.length());
		System.out.println(password2);
		System.out.println(password2.length());
		
	}

}
