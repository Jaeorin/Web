<%@ page import="java.sql.*" contentType="text/html; charset=EUC-KR"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection connection = DriverManager.getConnection(url, "madang", "madang");
	Statement statement = connection.createStatement();
	String bookid = request.getParameter("bookid");
	if(bookid == null){
	%>
	<jsp:forward page="booklist.jsp"/>
	<%
	}
	ResultSet resultset = statement.executeQuery("SELECT * FROM book WHERE bookid = '" + bookid + "'");
	if(resultset != null){
		resultset.next();
%>
<html>
<head>
<meta http-equiv="content-typr" content="text/html; charset=euc-kr">
<title>** BOOK VIEW **</title>
</head>
<body bgcolor="white" text="black" link="blue" vlink="purple"
	alink="red">
	<table border="1">
		<tr>
			<td width="150" height="23">
				<p align="center">
					<span style="font-size: 9pt;">å �� ��</span>
				</p>
			</td>
			<td width="513">
				<p>
					<span style="font-size: 9pt;"><%=resultset.getString("BOOKNAME")%></span>
				</p>
			</td>
		</tr>
		<tr>
			<td width="150" height="23">
				<p align="center">
					<span style="font-size: 9pt;">�� �� ��</span>
				</p>
			</td>
			<td width="513">
				<p>
					<span style="font-size: 9pt;"><%=resultset.getString("PUBLISHER")%></span>
				</p>
			</td>
		</tr>
		<tr>
			<td width="150" height="23">
				<p align="center">
					<span style="font-size: 9pt;">å �� ��</span>
				</p>
			</td>
			<td width="513">
				<p>
					<span style="font-size: 9pt;"><%=resultset.getString("PRICE")%></span>
				</p>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td width="150">
				<p align="right"><span style="font-size: 9pt;">
				<a href="booklist.jsp?">
				<font color = "black">���</font></a></span></p>
			</td>
		</tr>
	</table>
<%
	}
	statement.close();
	connection.close();
%>
</body>
</html>