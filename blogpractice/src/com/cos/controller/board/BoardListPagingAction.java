package com.cos.controller.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.controller.Action;
import com.cos.dao.BoardDAO;
import com.cos.domain.Board;
import com.cos.util.Code;

public class BoardListPagingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "main.jsp";

		int start = 0;
		int end = 5;
		
		if(request.getParameter("start") != null && request.getParameter("end") != null) {
			try {
				start = Integer.parseInt(request.getParameter("start"));
				end = Integer.parseInt(request.getParameter("end"));
			} catch (Exception e) {
				start = 0;
				end = 5;
			}
		
		}

		BoardDAO boardDAO = BoardDAO.getInstance();
		List<Board> list = boardDAO.findall(start, end);
		
		request.setAttribute("state", 1); // 1은 서블릿을 경유했다는 표시
		request.setAttribute("list", list);
		request.setAttribute("start", start);
		request.setAttribute("end", end);
		request.setAttribute("maxListNum", Code.getMaxListNum());
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
	}

}
