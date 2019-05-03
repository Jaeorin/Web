package com.cos.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.controller.Action;
import com.cos.dao.MemberDAO;
import com.cos.domain.Member;

public class MemberUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/update.jsp";

		HttpSession session = request.getSession();
		String sessionId = (String) session.getAttribute("userId");

		MemberDAO memberDAO = MemberDAO.getInstance();
		Member member = memberDAO.findByUserProfile(sessionId);
		
		request.setAttribute("member", member);
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		
	}

}
