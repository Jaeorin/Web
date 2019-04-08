<%@ page import="java.sql.*" contentType="text/html; charset=EUC-KR"%>
<%
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	Connection connection = DriverManager.getConnection(url, "madang", "madang");
	Statement statement = connection.createStatement();
	ResultSet resultset = statement.executeQuery("SELECT * FROM book");
%>
<html>
<head>
<meta http-equiv="content-typr" content="text/html; charset=euc-kr">
<title>** BOOK LIST **</title>
</head>
<body bgcolor="white" text="black" link = "blue" link="purple" alink="red">
	<table border="1">
		<tr>
			<td width="150" height="20" bgcolor="#D2E9F9">
				<p align="center">
					<span style="font-size: 8pt;"><b>BOOKNAME</b></span>
				</p>
			</td>
			<td width="150" height="20" bgcolor="#D2E9F9">
				<p align="center">
					<span style="font-size: 8pt;"><b>PUBLISHER</b></span>
				</p>
			</td>
			<td width="150" height="20" bgcolor="#D2E9F9">
				<p align="center">
					<span style="font-size: 8pt;"><b>PRICE</b></span>
				</p>
			</td>
		</tr>
		<%
			if (resultset != null) {
				while (resultset.next()) {
					String W_BOOKID = resultset.getString("bookid");
					String W_BOOKNAME = resultset.getString("bookname");
					String W_PUBLISHER = resultset.getString("publisher");
					String W_PRICE = resultset.getString("price");
		%>
		<tr>
			<td width="150" height="20">
				<p align="center">
					<span style="font-size: 9pt;"><a
						href="bookview.jsp?bookid= <%=W_BOOKID%>"> <font face="돋움체"
							color="black"> <%=W_BOOKNAME%>
						</font>
					</a> </span>
				</p>
			</td>
			<td width="150" height="20">
				<p align="center">
					<span style="font-size: 9pt;"> <font face="돋움체"
						color="black"> <%=W_PUBLISHER%>
					</font>
					</span>
				</p>
			</td>
			<td width ="150" height="20">
				<p align="center">
					<span style="font-size: 9pt;"><a
						href="bookview.jsp?bookid = <%=W_BOOKID%>"> <font face="돋움체"
							color="black"> <%=W_PRICE%>
						</font>
					</a> </span>
				</p>
			</td>
		</tr>
		<%
			}
			}
			statement.close();
			connection.close();
		%>
	</table>
	<table>
		<tr>
			<td>
				<p align="right">
					<b> <a href="booklist.jsp"> <font size="1" face="돋움체"
							color="black">LIST</font>
					</a>
					</b>
				</p>
			</td>
		</tr>

	</table>
</body>
</html>