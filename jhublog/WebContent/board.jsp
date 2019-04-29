<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>정현욱의 블로그</title>
<%@ include file="/include/CSS.jsp"%>
</head>
<body>
	<%@ include file="/include/navBar.jsp"%>
	<div class="container">
		<table class="table" border="1">
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
					<td>${item.title}</td>
					<td>${item.userID}</td>
					<td>${item.readCount}</td>
					<td>${item.createDate}</td>
					<td>${item.updateDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<%@ include file="/include/script.jsp"%>
</body>
</html>