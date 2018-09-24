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
	<h1>${vo.title }</h1>
	작성자 : ${vo.writer }<br>
	글 내용<br>
	<div style="border: 1px solid black">
		${vo.content }
	</div>
	조회수 : ${vo.hit }<br>
	<a href="update?num=${vo.num }">수정하기</a>
	<a href="delete?num=${vo.num }">삭제하기</a>
</body>
</html>