<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<%@ include file="/base/link.jsp" %>
</head>
<body>
	<%@ include file="/base/header.jsp" %>
	<form action="board?cmd=boardWriteProc" method="POST">
		<input type="text" name="title" /><br />
		<textarea rows="10" cols="30" name="content"></textarea>
		<input type="hidden" name="userID" value="cos" /><br />
		<input type="submit" value="완료" /><br />
	</form>
	<a href="board?cmd=boardList">목록</a>
	<%@ include file="/base/script.jsp" %>
</body>
</html>