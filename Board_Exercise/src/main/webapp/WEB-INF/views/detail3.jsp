<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>상세글내용</h1>
<table class="table table-striped">
	<tr>
		<td>글번호</td><td>${vo.num }</td>
	</tr>
	<tr>
		<td>글제목</td><td>${vo.title }</td>
	</tr>
	<tr>
		<td>작성자</td><td>${vo.writer }</td>
	</tr>
	<tr>
		<td>내용</td><td><div style="width: 500px; height: 300px">${vo.content }</div></td>
	</tr>
	<tr>
		<td>작성일</td><td>${vo.regdate }</td>
	</tr>
	<tr>
		<td>이전글</td><td><a href="${pageContext.request.contextPath }/detail3?num=${prev.num}">
		${prev.title }</a></td>
	</tr>
	<tr>
		<td>다음글</td><td><a href="${pageContext.request.contextPath }/detail3?num=${next.num}">
		${next.title }</a></td>
	</tr>
</table>
</body>
</html>