<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<body>

<h2>The XMLHttpRequest Object</h2>

<button type="button" onclick="loadDoc()">Request data</button>

<p id="demo"></p>

<script>
	function loadDoc() {
		
		let data = {
			Fname:"Henry",
			Lname:"Ford"
		}
		
		console.log(data);
		
		// parse는 자바스크립트 오브젝트로 변경
		// let jsonData = JSON.parse(data);
		
		// stringify 는 자바스크립트 오브젝트를 json String으로 변경
		let jsonString = JSON.stringify(data);
		console.log(jsonString);
		
		let data1 = JSON.parse(jsonString);
		
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById("demo").innerHTML = this.responseText;
		    }
		};
		
	xhttp.open("POST", "hello", true);
	
	// application/x-www-form-urlencoded
	xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhttp.send("fname=Henry&lname=Ford");
	
	// text/plain
// 	xhttp.setRequestHeader("Contetnt-type", "text/plain")
//	xhttp.send("fname=Henry&lname=Ford");

	// application/json
//	xhttp.setRequestHeader("Contetnt-type", "application/json")
//	xhttp.send(jsonString);
	}
</script>

</body>

</html>
