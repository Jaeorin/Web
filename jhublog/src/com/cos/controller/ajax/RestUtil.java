package com.cos.controller.ajax;

import com.cos.dao.MemberDAO;

public class RestUtil {

	public String duplicateId(String userId) {

		MemberDAO memberDAO = MemberDAO.getInstance();

		int result = memberDAO.findByUserId(userId);

		if (result == 0) {
			return "OK";
		}

		return "ERROR";
		
	}

}
