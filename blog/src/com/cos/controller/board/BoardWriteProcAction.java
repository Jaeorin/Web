package com.cos.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.controller.Action;

public class BoardWriteProcAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//글쓰기를 수행하고 home.jsp
		
		String url = "home.jsp";

		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
