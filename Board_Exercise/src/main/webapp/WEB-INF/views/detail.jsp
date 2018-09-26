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
	<h1>${vo.title }</h1>
	작성자 : ${vo.writer }<br>
	글 내용<br>
	<div style="border: 1px solid black">
		${vo.content }
	</div>
	조회수 : ${vo.hit }<br>
	<a href="update?num=${vo.num }">수정하기</a>
	<a href="delete?num=${vo.num }">삭제하기</a>
	<a href="<c:url value='boardlist?spageNum=${pageNum }'/>">이전으로</a><br>
	<br><br>
	<table class="table table-striped" id="commTable">
		<tr>
			<th width="150">작성자</th>
			<th>댓글내용</th>
			<th width="100">삭제</th>
		</tr>
		<c:forEach var="item" items="${list }">
		<tr>
			<td>${item.writer }</td>
			<td>${item.content }</td>
			<td><a href="commDelete?num=${item.cnum }">삭제</a></td>
		</tr>
		</c:forEach>
	</table>
	<form name="frm" method="post">
	<div style="width: 150px; float: left;">
	작성자<br>
	<input type="text" name="writer" />	
	</div>
	<div style="width: 200px; float: left; margin-left: 100px;">
	댓글 내용<br>
	<input type="text" name="content"/>
	</div>
	<div style="width: 200px; float: left; margin-left: 100px;">
	비밀번호<br>
	<input type="text" name="pwd"/>
	<input type="hidden" name="mnum" value=${vo.num } />
	</div>
	<button type="button" id="btn1">댓글작성!</button>
	</form>
</body>
<script type="text/javascript">
	$('#btn1').click(function() {
		$.ajax({
			type: "post",
			url : "commInsert",
			data : $('form[name=frm]').serializeArray(),
			dataType : 'json',
			success : function(data) {
				if(data != null){
					writeComm(data);
				}
			}
		});
	});
	
	function writeComm(data) {
		var code = '';
		tt = data[0];
		var cnum = data[0].cnum;
		code = "<tr><td>"+tt.writer+"</td>"
		+ "<td>"+tt.content+"</td>"
		+ "<td class='"+cnum+"'>삭제</td></tr>"; //동적으로 이벤트걸어서 삭제 처리 해보기
			var test = $('#commTable tr').eq(0);
			test.after(code);
			
		$(document).on('click','.'+cnum+'',function(){
			console.log(cnum);
		});	
	}
	
</script>
</html>