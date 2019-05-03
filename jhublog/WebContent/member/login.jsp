<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>jhublog</title>
	<%@ include file="/include/CSS.jsp"%>
</head>

<body>

	<%@ include file="/include/navBar.jsp"%>
	<br />
	
	<form name="loginform" action="board?cmd=memberLoginProc" method="POST">
		<c:choose>
			<c:when test="${empty cookie.cookieId.value}">
				<input type="text" name="userId" placeholder="로그인" required /><br />
			</c:when>
			<c:otherwise>
				<input type="text" name="userId" value="${cookie.cookieId.value}" required /><br />
			</c:otherwise>
		</c:choose>
		<input type="password" name="userPassword" placeholder="비밀번호" required /><br />
		Remember me?<input type="checkbox" name="idSave" value="on" />
	</form>
	<ul class="pagination">
		<li class="page-item"><a class="page-link" href="javascript:loginform.submit();">완료</a></li>
		<li class="page-item"><a class="page-link" href="board?cmd=boardListPage">목록</a></li>
	</ul>
	<%@ include file="/include/script.jsp"%>
</body>
</html>