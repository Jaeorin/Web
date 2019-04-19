package com.cos.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.controller.Action;
import com.cos.dao.MemberDAO;
import com.cos.util.MyUtils;

public class MemberLoginProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "main.jsp";

		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");

		MemberDAO memberDAO = MemberDAO.getInstance();
		int result = memberDAO.findByUserIdAndUserPassword(userId, userPassword);

		if (result == 1) {
			// 로그인 완료(세션)
			
			// main.jsp로 이동
			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		} else if (result == 0) {
			// 로그인 실패
			MyUtils.script("아이디 혹은 비밀번호가 일치하지 않습니다.", response);
		} else {
			// 서버오류
			MyUtils.script("서버에러", response);
		}

	}

}
