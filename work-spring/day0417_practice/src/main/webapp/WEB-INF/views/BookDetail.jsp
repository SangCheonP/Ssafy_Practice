<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 구체적인 정보 표시</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/book/update" method="post">
		<fieldset>
			<legend>책 세부사항</legend>
			<input type="hidden" value="${book.isbn}" name="isbn">
			<input type="text" value="${book.title}" name="title"><br>
			<input type="text" value="${book.writer}" name="writer"><br>
			<input type="text" value="${book.price}" name="price"><br>
			<input type="submit" value="수정하기"> 
			<button type="button">삭제하기</button>
		</fieldset>
	</form>
</body>
</html>