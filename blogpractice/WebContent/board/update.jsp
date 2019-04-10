<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="board?cmd=boardUpdateProc" method="POST">
		<table border="1">
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>내용</td>
				<td>아이디</td>
				<td>조회수</td>
				<td>작성일</td>
				<td>수정일</td>
			</tr>
			<tr>
				<td><input name="num" type="text" value="${board.num}" readOnly /></td>
				<td><input name="title" type="text" value="${board.title}" /></td>
				<td><textarea name="content" row="10" cols="30">${board.content}</textarea></td>
				<td>${board.userID}</td>
				<td>${board.readCount}</td>
				<td>${board.createDate}</td>
				<td>${board.updateDate}</td>
			</tr>
		</table>
		<input type="submit" value="완료" /><br />
	</form>
	<a href="board?cmd=boardList">목록</a>
</body>
</html>