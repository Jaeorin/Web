<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>jhublog</title>
	<%@ include file="/include/CSS.jsp"%>
</head>

<body>

	<%@ include file="/include/navBar.jsp"%>
	
	<form id="form" name="memberupdateform" action="member?cmd=memberUpdateProc" method="POST">
		<input id="userId" type="text" name="userId" value="${member.userId}" readonly />아이디<br />
		<input id="pw1" type="password" name="userPassword" placeholder="비밀번호" required />비밀번호<br />
		<input id="pw2" type="password" placeholder="비밀번호확인" required />비밀번호 확인
		<input type="button" value="중복확인" onclick="validateDuplicatePw()" /><br />
		<input type="email" name="userEmail" value="${member.userEmail}" required />이메일<br />
		<input type="text" name="userPhone" value="${member.userPhone}" required />전화번호<br />
		<input type="text" id="userAddr" name="roadFullAddr" style="width:500px;" value="${member.userAddr}" readonly required />주소
		<input type="button" onClick="goPopup();" value="주소검색" /><br />
		<c:choose>
		<c:when test="${member.userGender eq '남'}">
			<input type="radio" name="userGender" value="남" checked />남
			<input type="radio" name="userGender" value="여" />여<br />
		</c:when>
		<c:otherwise>
			<input type="radio" name="userGender" value="남" />남
			<input type="radio" name="userGender" value="여" checked />여<br />
		</c:otherwise>
		</c:choose>
		
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="javascript:validateUpdate();">완료</a></li>
			<li class="page-item"><a class="page-link" href="board?cmd=boardListPage">목록</a></li>
		</ul>
	</form>
	
	<script>
	
		let checkPw = 1;
		
		function validateUpdate(){
	
			let Pw = document.querySelector("#pw1");
			
			if(checkPw==1){
				alert('비밀번호 중복체크를 해주세요');
				Pw.focus();
			}else{
				memberupdateform.submit();
			}
			
		}
		
		function validateDuplicatePw(){
			
			let pw1 = document.querySelector("#pw1");
			let pw2 = document.querySelector("#pw2");
			
			if(pw1.value == pw2.value){
				checkPw = 0;
				alert('비밀번호가 일치합니다');
			}else{
				pw1.value ="";
				pw2.value ="";
				pw1.focus();
				alert('비밀번호가 일치하지 않습니다');
			}
		}
		
		function goPopup(){
			var pop = window.open("jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
		}
		
		function jusoCallBack(roadFullAddr){
			document.memberupdateform.roadFullAddr.value = roadFullAddr;
		}
	
	</script>
	<%@ include file="/include/script.jsp"%>
</body>
</html>