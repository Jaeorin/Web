

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Hello() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		System.out.println(name);
		
		//DB연결 - DB insert
		String data = "hello everyone";
		PrintWriter out = response.getWriter();
		out.println(data);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		// application/x-www-form-urlencoded
//		String fname = request.getParameter("fname");
//		String lname = request.getParameter("lname");
//		String data = fname + lname;
//		PrintWriter out = response.getWriter();
//		out.println(data);
		
		
		// text/plain
//		BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
//		또는
//		BufferedReader br = request.getReader();
//		
//		String line;
//		
//		StringBuffer sb = new StringBuffer();
//		while((line = br.readLine()) != null) {
//			sb.append(line);
//			sb.append('\r');
//		}
//		
//		br.close();
//
//		System.out.println(sb);
//		
//		PrintWriter out = response.getWriter();
//		out.println(sb);
	
		// application/json
		// gson
//		BufferedReader br = request.getReader();
//		
//		String data = br.readLine();
//		
//		Gson gson = new Gson();
//		Name n = gson.fromJson(data, Name.class);
//		
//		PrintWriter out = response.getWriter();
//		
//		out.print(n.getFname());
//		out.print(n.getLname());
		
		// json 심플 라이브러리
//		JSONParser parser = new JSONParser();
//		
//		try {
//			JSONObject obj = (JSONObject)parser.parse(data);
//			Name n2 = new Name();
//			n.setFname((String)obj.get("Fname"));
//			n.setLname((String)obj.get("Lname"));
//			System.out.println(n2.getFname());
//			System.out.println(n2.getLname());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

	}

}
