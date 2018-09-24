<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board Insert</title>
</head>
<body>
	<h1>글 쓰기 페이지</h1>
	<form action="boardInsert" method="post">
		작성자 이름 : <input type="text" name="writer" /><br>
		글 제목 : <input type="text" name="title" /><br>
		글 내용<br>
		<textarea rows="5" cols="50" name="content"></textarea><br />
		<input type="submit" value="작성" />
	</form>
</body>
</html>