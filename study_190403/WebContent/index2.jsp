<%@page import="study_190403.Cal"%>
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
		int num = 1;
		Cal c = new Cal();
	%>
	<%=c.add(10, 20)%>
</body>
</html>