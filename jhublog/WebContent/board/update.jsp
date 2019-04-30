<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>jhublog</title>
	<%@ include file="/include/CSS.jsp"%>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.css" rel="stylesheet">
</head>
<body>
	<%@ include file="/include/navBar.jsp"%>
	
	<br />
	
	<div class="container">
		<form name="updateform" action="board?cmd=boardUpdateProc" method="POST">
			<table class="table" border="1">
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>아이디</td>
					<td>조회수</td>
					<td>작성일</td>
					<td>수정일</td>
				</tr>
				<tr>
					<td><input name="num" type="text" value="${board.num}" readOnly /></td>
					<td><input name="title" type="text" value="${board.title}" /></td>
					<td>${board.userID}</td>
					<td>${board.readCount}</td>
					<td>${board.createDate}</td>
					<td>${board.updateDate}</td>
				</tr>
			</table>
			
			<textarea id="summernote" name="editordata">${board.content}</textarea>
			
			<br />
			
			<ul class="pagination">
				<li class="page-item"><a class="page-link" href="javascript:updateform.submit();">완료</a></li>
				<li class="page-item"><a class="page-link" href="board?cmd=boardListPage">목록</a></li>
			</ul>
		</form>
	</div>
	
	<%@ include file="/include/script.jsp"%>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
	<script>
      $('#summernote').summernote({
        tabsize: 2,
        height: 100
      });
    </script>
</body>
</html>