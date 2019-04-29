<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!-- 메뉴바 시작 -->
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<!-- 배너 -->
	<a class="navbar-brand" href="main.jsp">Blog</a>
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
			<li class="nav-item">
				<a class="nav-link" href="#">로그인</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">회원가입</a>
			</li>
		</ul>
	</div>
</nav>