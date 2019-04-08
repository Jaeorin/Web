package study_190328;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class bookview {
	Connection connection;
	Statement statement;
	ResultSet resultset;

	public bookview() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid = "madang";
		String pwd = "madang";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			System.out.println("�����ͺ��̽� ���� �غ� ...");
			connection = DriverManager.getConnection(url, userid, pwd);
			System.out.println("�����ͺ��̽� ���� ����");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	void sqlRun() {
		String query = "SELECT * FROM book";
		try {
			statement = connection.createStatement();
			resultset = statement.executeQuery(query);
			System.out.println("BOOK no \tBOOK NAME \t\tPUBLISHER \tPRICE");
			while (resultset.next()) {
				System.out.print("\t" + resultset.getInt(1));
				System.out.print("\t" + resultset.getString(2));
				System.out.print("\t\t" + resultset.getString(3));
				System.out.println("\t" + resultset.getInt(4));
			}
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
