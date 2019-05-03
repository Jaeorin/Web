package com.cos.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.cos.dto.MemberUpdateDTO;
import com.cos.controller.Action;
import com.cos.dao.MemberDAO;
import com.cos.util.MyUtils;
import com.cos.util.SHA256;

public class MemberUpdateProcAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "main.jsp";
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String userPassword = request.getParameter("userPassword");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String userGender = request.getParameter("userGender");
		String userAddr = request.getParameter("roadFullAddr");
		String salt = "cos";
		userPassword = SHA256.getEncrypt(userPassword, salt);
		
		MemberUpdateDTO mDto = new MemberUpdateDTO();
		mDto.setUserId(userId);
		mDto.setUserPassword(userPassword);
		mDto.setUserEmail(userEmail);
		mDto.setUserPhone(userPhone);
		mDto.setUserGender(userGender);
		mDto.setUserAddr(userAddr);
		
		MemberDAO memberDAO = MemberDAO.getInstance();
		int result = memberDAO.update(mDto);

		if (result == 1) {

			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		} else {
			MyUtils.script("error", response);
		}

	}

}
