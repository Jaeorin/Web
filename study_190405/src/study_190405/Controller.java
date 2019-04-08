package study_190405;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//http://localhost:8000/Context 가 앞에 생략됨
@WebServlet("/study_190405/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
	      out.print("<HTML>");
	      out.print("<BODY>");
	      out.print("<table border =\"1\">");       
	      List<User>list = DataSource.findAll();
	      for(int i = 0 ;i<list.size(); i++){
	         User li = list.get(i);
	      out.print("<tr>");
	      out.print("<td>"+li.getNo()+"</td>");
	      out.print("<td>"+li.getId()+"</td>");
	      out.print("<td>"+li.getName()+"</td>");
	      out.print("<td>"+li.getPhone()+"</td>");
	      out.print("</tr>");
	      }
	      out.print("</BODY>");
	      out.print("</HTML>");


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
