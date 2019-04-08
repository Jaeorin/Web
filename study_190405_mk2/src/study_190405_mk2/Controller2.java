package study_190405_mk2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//�����(Ŭ���̾�Ʈ)�� ���� ��û�� �ϸ� ��Ĺ��
//request��ü�� response ��ü�� ����
//get������� ȣ������� doGet()
//post������� ȣ������� doPost()
//�Ű������� �����ݴϴ�.

//http://localhost:8000/study_190405_mk2/
@WebServlet("/study_190405_mk2")
public class Controller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Controller2() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cmd = request.getParameter("addr");
		System.out.println(cmd);
		if(cmd.equals("index")){
			response.sendRedirect("study_190405_mk2/index2.jsp");
		}else if(cmd.equals("signin")){
			response.sendRedirect("study_190405_mk2/signin.jsp");
		}else if(cmd.equals("signup")){
			response.sendRedirect("study_190405_mk2/signup.jsp");
		}else if(cmd.equals("user")){
			User2 user = new User2();
			user.setId("ssar");
			user.setName("sungju");
			
			request.setAttribute("stateCode", 200);
			request.setAttribute("stateMessage", "ok");
			request.setAttribute("user", user);
			RequestDispatcher dis = request.getRequestDispatcher("study_190405_mk2/user.jsp");
			dis.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
