<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="/blogpractice/CSS/styles.css" rel="stylesheet">
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
	<textarea id="reply" rows="3" cols="45"></textarea><br />
	<button onclick="boardReplyWrite()">댓글입력</button><br />
	<div class="reply-box">
		<div class="reply-item">
			<span class="reply-userid">ssar</span>
			<span class="reply-createdate">2019-05-02 10:00</span>
			<div class="reply-delete">
				<i class="material-icons">clear</i>
			</div>
			<p class="reply-content">반갑습니다</p>
		</div>
	</div>
	<a href="board?cmd=boardDelete&num=${board.num}">삭제</a>
	<a href="board?cmd=boardUpdate&num=${board.num}">수정</a>
	<a href="board?cmd=boardList">목록</a>
	<%@ include file="/base/script.jsp" %>

	<script>
	
		function boardReplyWrite(){
			// 댓글
			let reply_el = document.querySelector("#reply");
			let content = reply_el.value;
			// 아이디
			let userId = "${sessionScope.userId}";
			// 시간
			let createDate = currentDate();
			let boardNum = "${board.num}";
			
			let replyDto = {
					"content": content,
					"userId": userId,
					"createDate" : createDate,
					"boardNum": boardNum
			};
			// 서버 구축되면 fetch() 돌리기
			fetch("http://localhost:8000/blogpractice/reply", {
				method: "POST",
				headers: {
					"Accept" : "text/plain",
					"Content-Type" : "application/json"
				},
				body: JSON.stringify(replyDto)
			}).then(function(res){
				return res.text();
			}).then(function(result){
				if(result=="OK"){
					let newDiv = document.createElement("div");
					newDiv.className = "reply-item";
					newDiv.innerHTML = '<span class="reply-userid">'+userId+'</span><span class="reply-createdate">'+createDate+'</span><div class="reply-delete"><i class="material-icons">clear</i></div><p class="reply-content">'+content+'</p>';
					document.querySelector(".reply-box").prepend(newDiv);
				}
			});
			
		}
		
		function currentDate(){
			let d = new Date();
			let mon;
			let day;
			let hour;
			let min;
			let sec;
			if(d.getMonth() < 10){
				mon = "0"+d.getMonth();
			}else{
				mon = d.getMonth();
			}
			if(d.getDay() < 10){
				day = "0"+d.getDay();
			}else{
				day = d.getDay();
			}
			if(d.getHours() < 10){
				hour = "0"+d.getHours();
			}else{
				hour = d.getHours();
			}
			if(d.getMinutes() < 10){
				min = "0"+d.getMinutes();
			}else{
				min = d.getMinutes();
			}
			if(d.getSeconds() < 10){
				sec = "0"+d.getSeconds();
			}else{
				sec = d.getSeconds();
			}
			let time = d.getFullYear()+"-"+mon+"-"+day+" "+hour+":"+min+":"+sec;
			return time;
		}
	</script>
</body>

</html>