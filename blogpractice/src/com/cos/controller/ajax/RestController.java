package com.cos.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/rest")
public class RestController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RestController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		RestUtil r = new RestUtil();
		
		String result = r.duplicateId(userId);
				
		PrintWriter out = response.getWriter();
		out.print(result); // println을 쓰면 ln 때문에 뒤에 \n이 붙어 같은 값이 아니게 된다(오류발생)
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
