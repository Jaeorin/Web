<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${empty list and state != 1}">
	<c:redirect url="board" />
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>정현욱의 블로그</title>
</head>
<body>
	<c:choose>
		<c:when test="${empty sessionScope.userId}">
			<a href="member?cmd=memberLogin">로그인</a>
			<a href="member?cmd=memberJoin">회원가입</a>
		</c:when>
		<c:otherwise>
			<%=session.getAttribute("userId")%>
			<a href="member?cmd=memberLogout">로그아웃</a>
		</c:otherwise>
	</c:choose>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>아이디</td>
			<td>조회수</td>
			<td>작성일</td>
			<td>수정일</td>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.num}</td>
				<td><a href="board?cmd=boardView&num=${item.num}">${item.title}</a></td>
				<td>${item.userID}</td>
				<td>${item.readCount}</td>
				<td>${item.createDate}</td>
				<td>${item.updateDate}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="board?cmd=boardWrite">글쓰기</a>
</body>
</html>