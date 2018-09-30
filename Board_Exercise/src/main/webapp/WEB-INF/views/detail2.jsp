<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="update2" method="post">
	작성자 : <input type="text" name="writer" value=${vo.writer }/><br />
	글제목 : <input type="text" name="title" value=${vo.title } /><br />
	내용<br>
	<textarea rows="5" cols="50" name="content">${vo.content }</textarea><br>
	<input type="hidden" name="num" value=${vo.num }>
	<input type="submit" value="수정" />	
</form>
</body>
</html>