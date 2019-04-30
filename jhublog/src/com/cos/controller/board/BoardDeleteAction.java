package com.cos.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.controller.Action;
import com.cos.dao.BoardDAO;
import com.cos.util.MyUtils;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));

		BoardDAO boardDAO = BoardDAO.getInstance();
		int result  = boardDAO.delete(num);

		if (result == 1) {
			String url = "board.jsp";

			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		} else if (result == 0) {
			MyUtils.script("SQLerror", "board?cmd=boardListpage", response);
		} else if (result == -1) {
			MyUtils.script("servererror", "board?cmd=boardListpage", response);
		}

	}

}
