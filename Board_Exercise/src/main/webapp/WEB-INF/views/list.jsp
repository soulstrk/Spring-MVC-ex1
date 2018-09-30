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
<title>게시판2</title>
</head>
<body>
<div class="container">
	<h1>글목록</h1>
	<table class="table table-striped">
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>작성자</td>
			<td>조회수</td>
			<td>작성일</td>
			<td>수정</td>
			<td>삭제</td>
			<td>상세글보기</td>
		</tr>
		<c:forEach var="vo" items="${list }">
			<tr>
				<td>${vo.num }</td>
				<td>${vo.title }</td>
				<td>${vo.writer }</td>
				<td>${vo.hit }</td>
				<td>${vo.regdate }</td>
				<td><a href="<c:url value='/detail2?num=${vo.num }'/>">수정</a></td>
				<td><a href="<c:url value='/delete2?num=${vo.num }'/>">삭제</a></td>
				<td><a href="<c:url value='/detail3?num=${vo.num }'/>">상세글보기</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
<div>
	<c:forEach var="i" begin="${pu.startPageNum }" end="${pu.endPageNum }">
		<c:choose>
			<c:when test="${pu.pageNum == i }">
				<a href='<c:url value="/boardlist2?pageNum=${i }&field=${field }&keyword=${keyword }"/>'>
				<span style="color:red">[${i }]</span></a>	
			</c:when>
			<c:otherwise>
				<a href='<c:url value="/boardlist2?pageNum=${i }&field=${field }&keyword=${keyword }"/>'>[${i }]</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>
<div>
	<form action="<c:url value='/boardlist2'/>" method="post">
		<select name="field">
			<option value="title" <c:if test="${field == 'title' }"> selected="selected" </c:if> >글제목</option>
			<option value="writer" <c:if test="${field == 'writer' }"> selected="selected" </c:if> >작성자</option>
			<option value="content" <c:if test="${field == 'content' }"> selected="selected" </c:if> >내용</option>
		</select>
		<input type="text" name="keyword" value="${keyword }"/>
		<input type="submit" value="검색" />
	</form>
</div>
<a href="<c:url value='/boardlist2'/>">전체글목록</a>
<a href="<c:url value='/resources/index.html'/>">홈으로</a>	
</div>
</body>
</html>