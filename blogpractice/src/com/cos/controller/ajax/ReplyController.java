package com.cos.controller.ajax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.domain.Reply;
import com.google.gson.Gson;

@WebServlet("/reply")
public class ReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReplyController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		BufferedReader br = request.getReader();

		// System.out.println(br.readLine());
		Gson gson = new Gson();
		Reply reply = gson.fromJson(br.readLine(), Reply.class);

		RestUtil r = new RestUtil();
		int result = r.save(reply);

		PrintWriter out = response.getWriter();

		if (result == 1) {
			out.print("OK");
		} else {
			out.print("ERROR");
		}

		// 성공 시 DB에 Insert하고 out.print("OK");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
