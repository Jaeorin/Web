
<%@page import="study_190405.User"%>
<%@page import="study_190405.DataSource"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		List<User> list = DataSource.findAll();
	%>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>아이디</td>
			<td>이름</td>
			<td>전화번호</td>
		</tr>
		<%for(User i: list){%>
		<tr>
			<td><%=i.getNo()%></td>
			<td><%=i.getId()%></td>
			<td><%=i.getName()%></td>
			<td><%=i.getPhone()%></td>
		</tr>
		<%}%>
	</table>
</body>
</html>