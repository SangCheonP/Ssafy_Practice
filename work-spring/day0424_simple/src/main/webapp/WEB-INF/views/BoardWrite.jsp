<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardWrite</title>
</head>
<body>
	<%@ include file="Header.jsp" %>

<!-- 일단 BoardServlet이 로그인 체크 해서 나한테 일 시킴 -->
    <!-- 그래도 혹시 더블 체크 하고싶으면 여기서도 세션에 loginInfo 여부 체크할 수 있음. -->
    <form action="${root}/board/write" method="post">
        제목 : <input type="text" name="title"><br>
        내용 : 
        <textarea rows="10" cols="20"></textarea><br>
        <input type="submit" value="작성완료">
    </form>
</body>
</html>