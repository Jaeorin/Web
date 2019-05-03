<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<!-- 메뉴바 시작 -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<!-- 배너 -->
	<a class="navbar-brand" href="main.jsp">jhublog</a>
	<!-- 화면 축소 시 카테고리 모음 버튼 생성 -->
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
		<span class="navbar-toggler-icon"></span>
	</button>
	<!-- 카테고리 모음 버튼에 반응하는 div -->
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
		<!-- 카테고리(각 페이지별 링크) -->
		<ul class="navbar-nav">
			<li class="nav-item">
				<a class="nav-link" href="board?cmd=boardListPage">게시판</a>
			</li>
			<c:choose>
				<c:when test="${empty sessionScope.userId}">
					<li class="nav-item">
						<a class="nav-link" href="member?cmd=memberLogin">로그인</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="member?cmd=memberJoin">회원가입</a>
					</li>
				</c:when>
				<c:otherwise>
					<li class="nav-item">
						<a class="nav-link" href="member?cmd=memberUpdate"><%=session.getAttribute("userId")%> <%=session.getAttribute("admin")%>님, 환영합니다!</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="member?cmd=memberLogout">로그아웃</a>
					</li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</nav>
