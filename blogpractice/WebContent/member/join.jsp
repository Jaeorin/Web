<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="board?cmd=memberJoinProc" method="POST" onsubmit="return validateJoin()">
		<input id="userID" type="text" name="userId" placeholder="아이디" required />아이디
		<input type="button" value="중복확인" onclick="validateDuplicateID()"><br />
		<input id="pw1" type="password" name="userPassword" placeholder="비밀번호" required />비밀번호<br />
		<input id="pw2" type="password" placeholder="비밀번호 확인" required />비밀번호 확인<br />
		<input type="email" name="userEmail" placeholder="이메일" required />이메일<br />
		<input type="text" name="userPhone" placeholder="전화번호" required />전화번호<br />
		<input type="radio" name="userGender" value="남" checked required />남
		<input type="radio" name="userGender" value="여" />여<br />
		<input type="submit" value="회원가입" /><br />
	</form>

	<a href="board?cmd=boardList">목록</a>
<script>
	function validateJoin(){
		var pw1 = document.querySelector("#pw1");
		var pw2 = document.querySelector("#pw2");
		
		console.log(pw1.value);
		console.log(pw2.value);
		
		if(pw1.value == pw2.value){
			return true;
		}else{
			pw1.value ="";
			pw2.value ="";
			pw1.focus();
			alert('비밀번호가 일치하지 않습니다');
            return false;
		}
	}
		
	function validateDuplicateID(){
		var userID_element = document.querySelector("#userID");
		var userID = userID_element.value;
		alert(userID);
	}
	
	function validateJoin2(){
		var pw1 = document.getElementById("pw1").value;
		var pw2 = document.getElementById("pw2").value;
		console.log(pw1);
		console.log(pw2);
		
		if(pw1 != pw2){
			alert(pw1);
			alert(pw2);
			alert('비밀번호가 틀렸습니다. 다시 입력해 주세요');
            return false;
		}

	}
	
</script>
</body>
</html>