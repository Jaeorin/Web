package com.cos.controller.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.controller.Action;
import com.cos.domain.Board;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//DB에서 List가져오고 리퀘스트에 담아서 home.jsp로 이동
		
		//DB에서 List가져옴
		List<Board> list = new ArrayList<Board>();
		list.add(new Board(1, "제목", "내용입니다.", "ssar", 0));
		list.add(new Board(2, "제목", "내용입니다.", "ssar", 0));
		list.add(new Board(3, "제목", "내용입니다.", "ssar", 0));
		list.add(new Board(4, "제목", "내용입니다.", "ssar", 0));
		list.add(new Board(5, "제목", "내용입니다.", "ssar", 0));
		list.add(new Board(6, "제목", "내용입니다.", "ssar", 0));
		list.add(new Board(7, "제목", "내용입니다.", "ssar", 0));
		list.add(new Board(8, "제목", "내용입니다.", "ssar", 0));
		list.add(new Board(9, "제목", "내용입니다.", "ssar", 0));
		list.add(new Board(10, "제목", "내용입니다.", "ssar", 0));
		
		//리퀘스트에 담음
		request.setAttribute("list", list);
		
		//home.jsp로 이동
		String url = "home.jsp";
		
		RequestDispatcher dis = request.getRequestDispatcher(url);
		dis.forward(request, response);
		// response.sendRedirect(url);

	}

}
