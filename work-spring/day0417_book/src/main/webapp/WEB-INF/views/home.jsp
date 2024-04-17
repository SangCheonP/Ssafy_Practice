<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
</head>
<body>
	<h1>Home</h1>
	<hr>
	<a href="<%=request.getContextPath() %>/book/list">[ 도서 목록 ]</a>
	<a href="<%=request.getContextPath() %>/book/add">[ 도서 추가 ]</a>
</body>
</html>