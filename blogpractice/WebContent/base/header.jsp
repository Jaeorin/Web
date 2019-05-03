<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<!-- 메뉴바 시작 -->
	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<!-- Brand -->
		<a class="navbar-brand" href="main.jsp">Blog</a>
			<!-- Toggler/collapsibe Button -->
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
				<span class="navbar-toggler-icon"></span>
			</button>
			<!-- Navbar links -->
			<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav">
				<li class="nav-item">
					<c:choose>
						<c:when test="${empty sessionScope.userId}">
							<a class="nav-link" href="member?cmd=memberLogin">로그인</a>
						</c:when>
						<c:otherwise>
							<a class="nav-link" href="member?cmd=memberLogout">로그아웃</a>
						</c:otherwise>
					</c:choose>
				</li>
				<li class="nav-item">
				<a class="nav-link" href="member?cmd=memberJoin">회원가입</a>
				</li>
			</ul>
		</div> 
	</nav>
	<!-- 메뉴바 끝 -->