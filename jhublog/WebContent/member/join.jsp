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
	
	<form name="joinform" action="board?cmd=memberJoinProc" method="POST">
		<input type="text" name="userId" id="userId" placeholder="아이디" required />아이디
		<input type="button" value="중복확인" onclick="validateDuplicateId()" /><br />
		<input type="password" name="userPassword" id="pw1" placeholder="비밀번호" required />비밀번호<br />
		<input type="password" id="pw2" placeholder="비밀번호 확인" required />비밀번호 확인
		<input type="button" value="중복확인" onclick="validateDuplicatePw()" /><br />
		<input type="email" name="userEmail" placeholder="이메일" required />이메일<br />
		<input type="text" name="userPhone" placeholder="전화번호" required />전화번호<br />
		<input type="text" name="roadFullA18ddr" id="roadFullAddr" style="width:500px;" />주소
		<input type="button" onClick="goPopup();" value="주소검색" /><br />
		<input type="radio" name="userGender" value="남" checked />남
		<input type="radio" name="userGender" value="여" />여<br />
		
		<ul class="pagination">
			<li class="page-item"><a class="page-link" href="javascript:validateJoin();">완료</a></li>
			<li class="page-item"><a class="page-link" href="board?cmd=boardListPage">목록</a></li>
		</ul>
		
	</form>
	
	<script>
	
		let checkId = 1;
		let checkPw = 1;
		
		function validateJoin(){
			
			let Id = document.querySelector("#userId");
			let Pw = document.querySelector("#pw1");
			
			if(checkId==1){
				alert('아이디 중복체크를 해주세요');
				Id.focus();
			}else{
				if(checkPw==1){
					alert('비밀번호 중복체크를 해주세요');
					Pw.focus();
				}else{
					joinform.submit();
				}
			}
		}
		
		
		function loadAjax(userId) {
			let xhttp = new XMLHttpRequest();
			xhttp.onreadystatechange = function() {
				if (this.readyState == 4 && this.status == 200) {
					if(this.responseText == "OK"){
						alert("사용 가능한 아이디입니다");
						checkId = 0;
					} else {
						alert("중복된 아이디가 있습니다");
					} 
				}
			};
			xhttp.open("GET", "rest?userId="+userId, true);
			xhttp.send();
		}
			
		function validateDuplicateId(){
			let userId_element = document.querySelector("#userId");
			let userId = userId_element.value;
			
			loadAjax(userId);
	
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
			document.joinform.roadFullAddr.value = roadFullAddr;
		}
		
	</script>
	<%@ include file="/include/script.jsp"%>
</body>
</html>