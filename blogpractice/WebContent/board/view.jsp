<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<%
		pageContext.setAttribute("data", "안녕");
	%>
	session : ${sessionScope.userId}<br />
	request : ${requestScope.board.num}<br />
	page : ${pageScope.data}<br />
	application : ${applicationScope.test}<br />
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
			<td>${board.num}</td>
			<td>${board.title}</td>
			<td>${board.content}</td>
			<td>${board.userID}</td>
			<td>${board.readCount}</td>
			<td>${board.createDate}</td>
			<td>${board.updateDate}</td>
		</tr>

	</table>
	<a href="board?cmd=boardDelete&num=${board.num}">삭제</a>
	<a href="board?cmd=boardUpdate&num=${board.num}">수정</a>
	<a href="board?cmd=boardList">목록</a>
	<%@ include file="/base/script.jsp" %>
</body>
</html>