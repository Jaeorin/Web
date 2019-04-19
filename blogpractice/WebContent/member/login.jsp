<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="board?cmd=boardWriteProc" method="POST">
		<input type="text" name="userId" placeholder="로그인" required /><br />
		<input type="password" name="userPassword" placeholder="비밀번호" required /><br />
		<input type="submit" value="로그인" /><br />
	</form>
	<a href="board?cmd=boardList">목록</a>
</body>
</html>