package com.cos.controller.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.controller.Action;
import com.cos.dao.BoardDAO;
import com.cos.domain.Board;
import com.cos.util.MyUtils;

public class BoardViewtAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// request.setAttribute() -> Object
		// request.getAttribute() -> Object -> EL표현식 $()
		// request.getParameter() -> String
		int num = Integer.parseInt(request.getParameter("num"));
		
		HttpSession session = request.getSession();
		String sessionId = (String)session.getAttribute("userId");

		// DAO -> Data Access Object 객체 생성(클래스 안에 해당 함수 생성)
		BoardDAO boardDAO = BoardDAO.getInstance();
		// 상세보기 시에 조회수 증가.
		int result = boardDAO.updateReadCount(num);
		// 상세보기를 위해 객체를 들고옴
		Board board = boardDAO.findnum(num);

		// 권한검사
		if(!board.getUserID().equals(sessionId)){
			MyUtils.script("권한이 없습니다.", response);
			return;
		}
		
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
