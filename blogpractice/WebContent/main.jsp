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
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>정현욱의 블로그</title>
<%@ include file="/base/link.jsp"%>
</head>
<body>
	<%@ include file="/base/header.jsp"%>
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
					<td><a href="board?cmd=boardView&num=${item.num}">${item.title}</a></td>
					<td>${item.userID}</td>
					<td>${item.readCount}</td>
					<td>${item.createDate}</td>
					<td>${item.updateDate}</td>
				</tr>
			</c:forEach>
		</table>

		<ul class="pagination">
			<c:choose>
				<c:when test="${start==0}">
					<li class="page-item disabled"><a class="page-link"
						href="board?cmd=boardListPage&start=${start-5}&end=${end-5}">Previous</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link"
						href="board?cmd=boardListPage&start=${start-5}&end=${end-5}">Previous</a></li>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${maxListNum<start+5}">
					<li class="page-item disabled"><a class="page-link"
						href="board?cmd=boardListPage&start=${start+5}&end=${end+5}">Next</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item active"><a class="page-link"
						href="board?cmd=boardListPage&start=${start+5}&end=${end+5}">Next</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		
		<a href="board?cmd=boardWrite">글쓰기</a>
	</div>
	<%@ include file="/base/script.jsp"%>
</body>
</html>