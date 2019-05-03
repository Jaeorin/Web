<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
		
	<form name="writeform" action="board?cmd=boardWriteProc" method="POST">
		제목 : <input type="text" name="title" /><br />
		<textarea id="summernote" name="editordata"></textarea>
		<input type="hidden" name="userID" value="${sessionScope.userId}" /><br />
	</form>
	
	<ul class="pagination">
		<li class="page-item"><a class="page-link" href="javascript:writeform.submit();">완료</a></li>
		<li class="page-item"><a class="page-link" href="board?cmd=boardListPage">목록</a></li>
	</ul>
	
	<%@ include file="/include/script.jsp"%>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.11/summernote-bs4.js"></script>
	<script>
      $('#summernote').summernote({
        placeholder: '이곳에 원하는 글을 작성하세요',
        tabsize: 2,
        height: 100
      });
    </script>

</body>
</html>