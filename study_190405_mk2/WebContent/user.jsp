<%@page import="study_190405_mk2.User2"%>
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
		int stateCode = (Integer) request.getAttribute("stateCode");
		String stateMessage = (String) request.getAttribute("stateMessage");
	%>
	stateCode :
	<%=stateCode%>
	stateMessage :
	<%=stateMessage%>
	<hr />
	stateCode : ${stateCode}
	stateMessage : ${stateMessage}
	userid : ${user.id}
	username : ${user.name}
</body>
</html>