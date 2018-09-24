<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="update" method="post">
	<input type="hidden" value="${vo.num }" name="num"/>
	작성자 : <input type="text" name="writer" value="${vo.writer }"/><br>
	글제목 : <input type="text" name="title" value="${vo.title }" /><br>
	글 내용<br>
	<textarea rows="5" cols="50" name="content">${vo.content }</textarea>
	<input type="submit" value="수정하기" />
	</form>
</body>
</html>