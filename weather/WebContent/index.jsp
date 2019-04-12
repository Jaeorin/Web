<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/weather/data" method="GET">
	<select name="addr">
		<c:forEach var="item" items="${list}">
			<option>${item.addr2}-${item.addr3}</option>
		</c:forEach>
	</select>	
	<input type="submit" />
</form>
</body>
</html>