<%@page import="com.cos.domain.Board"%>
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
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>내용</td>
			<td>아이디</td>
			<td>조회수</td>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.num}</td>
				<td>${item.title}</td>
				<td>${item.content}</td>
				<td>${item.userID}</td>
				<td>${item.readCount}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
