package com.cos.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.controller.Action;
import com.cos.dao.BoardDAO;
import com.cos.domain.Board;
import com.cos.util.MyUtils;

public class BoardViewtAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int num = Integer.parseInt(request.getParameter("num"));

		BoardDAO boardDAO = BoardDAO.getInstance();
		int result = boardDAO.updateReadCount(num);
		Board board = boardDAO.findnum(num);
		
		if (board != null && result == 1) {
			request.setAttribute("board", board);

			String url = "board/view.jsp";

			RequestDispatcher dis = request.getRequestDispatcher(url);
			dis.forward(request, response);
		} else {
			MyUtils.script("error", "board?cmd=boardList", response);
		}
	}

}
