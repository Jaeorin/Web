package com.cos.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cos.controller.Action;
import com.cos.dao.MemberDAO;
import com.cos.util.DBManager;
import com.cos.util.MyUtils;

public class MemberLoginProcAction implements Action {

	static final Logger LOG = LogManager.getLogger(DBManager.class.getName());

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "main.jsp";

		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		String idSave = request.getParameter("idSave");

		if (idSave != null) {
			if (idSave.equals("on")) {
				Cookie cookie = new Cookie("cookieId", userId);
				cookie.setMaxAge(3600); // 3600초
				response.addCookie(cookie);
			}
		} else {
			Cookie cookie = new Cookie("cookieId", null);
			cookie.setMaxAge(0); // 3600초
			response.addCookie(cookie);
		}

		MemberDAO memberDAO = MemberDAO.getInstance();

		int result = memberDAO.findByUserIdAndUserPassword(userId, userPassword);

		if (result == 1) {
			// 로그인 완료(세션)
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
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
