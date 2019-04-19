<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<%
		application.setAttribute("test", "어플리케이션");
	%>
	${cookie.cookieId.value}
	<form action="board?cmd=memberLoginProc" method="POST">
		<input type="text" name="userId" placeholder="로그인" required /><br />
		<input type="password" name="userPassword" placeholder="비밀번호" required /><br />
		Remember me?<input type="checkbox" name="idSave" value="on" />
		<input type="submit" value="로그인" /><br />
	</form>
	<a href="board?cmd=boardList">목록</a>
</body>
</html>