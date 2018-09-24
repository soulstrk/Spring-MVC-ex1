<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#abc{
		text-align: center;
	}
	#btn1{
		position: relative;
		top: -60px;
	}	
</style>	
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
<c:if test="${!empty msg }"><script type="text/javascript">alert('글 등록 성공');</script></c:if>
<c:if test="${!empty upMsg }"><script type="text/javascript">alert('글 수정 성공');</script></c:if>
	<h1>게시판</h1>
	<table class="table table-striped">
		<tr>
			<th width="30">글 번호</th>
			<th width="100">작성자</th>
			<th width="200">제목</th>
			<th width="30">조회수</th>
		</tr>
		<c:forEach var="vo" items="${list }">
		<tr>
			<td>${vo.num }</td>
			<td>${vo.writer }</td>
			<td><a href="detail?num=${vo.num }&spageNum=${nowPageNum}">${vo.title }</a></td>
			<td>${vo.hit }</td>
		</tr>
		</c:forEach>
	</table>
	
	<!-- 페이지 갯수에 따라 [이전], [다음] 표시 -->
	<div id="abc">
	<c:if test="${startPage ne 1 }"><a href="boardlist?spageNum=${startPage-1 }">[이전]</a></c:if>
	<c:forEach begin="${startPage }" end="${endPage }" varStatus="index">
		<a href="boardlist?spageNum=${index.current }">${index.current }</a>
	</c:forEach>
	<c:if test="${maxPage>endPage }"><a href="boardlist?spageNum=${endPage+1 }">[다음]</a></c:if>
	</div>
	<br><button type="button" id="btn1">글 등록</button><br>
	<!-- 검색어 기능 -->
	<form action="boardlist" method="get">
		제목 <input type="checkbox" name="title" checked="checked" value="isCheck"/>
		글쓴이 <input type="checkbox" name="writer" value="isCheck"/>
		내용 <input type="checkbox" name="content" value="isCheck"/>
		<input type="text" name="search" />
		<input type="submit" value="입력" />
	</form>
</body>
<script type="text/javascript">
	runCheck();
	$('#btn1').click(function() {
		location.href="boardInsert";
	});
	
	function runCheck() {
		var title = <c:out value="${title == null? false: true}"/>;
		var writer = <c:out value="${writer == null? false: true}"/>;
		var content = <c:out value="${content == null? false: true}"/>;
		$('input[name=title]').prop('checked',title);
		$('input[name=writer]').prop('checked',writer);
		$('input[name=content]').prop('checked',content);		
	}
</script>
</html>