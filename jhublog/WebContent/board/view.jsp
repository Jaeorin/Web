<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<%@ include file="/include/CSS.jsp"%>
</head>
<body>

	<%@ include file="/include/navBar.jsp"%>

	<br />
	
	<div class="container">
		<table class="table" border="1">
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
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="board?cmd=boardUpdate&num=${board.num}" >수정</a></li>
			<c:choose>
				<c:when test="${empty sessionScope.userId}">
					<li class="page-item disabled">
						<a class="page-link" href="#">삭제</a>
					</li>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${sessionScope.admin eq '관리자'}">
							<li class="page-item">
								<a class="page-link" href="board?cmd=boardDelete&num=${board.num}">삭제</a>
							</li>
						</c:when>
						<c:when test="${sessionScope.admin eq '회원'}">
							<c:choose>
								<c:when test="${board.userID == sessionScope.userId}">
									<li class="page-item">
										<a class="page-link" href="board?cmd=boardDelete&num=${board.num}">삭제</a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="page-item disabled">
										<a class="page-link" href="#">삭제</a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:when>
					</c:choose>
				</c:otherwise>
			</c:choose>
			<li class="page-item"><a class="page-link" href="board?cmd=boardListPage" >목록</a></li>
		</ul>
	</div>
	<%@ include file="/include/script.jsp"%>
</body>
</html>