<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>
<%@ include file="Header.jsp" %>
<br>
	프로젝트 설정 제대로 돼서 돌아가는지 첫화면에서 체크!<br>
	<a href="${root}/board/list">[게시판목록]</a>
	<a href="${root}/board/write">[글작성]</a>
</body>
</html>