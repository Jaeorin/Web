

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/grib")
public class WeatherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public WeatherController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtils.connectionData(98, 75);
		
		Connection conn = DBManager.getConnection();
		List<Location> list = new ArrayList<Location>();
		final String SQL = "SELECT * FROM location";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Location l = new Location();
				l.setAddr1(rs.getString("addr1"));
				l.setAddr2(rs.getString("addr2"));
				l.setAddr3(rs.getString("addr3"));
				l.setNx(rs.getInt("nx"));
				l.setNy(rs.getInt("ny"));
				list.add(l);
			}
			
			request.setAttribute("list", list);
			RequestDispatcher dis =
					request.getRequestDispatcher("index.jsp");
			dis.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
