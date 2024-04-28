<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
=======
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>    
>>>>>>> ecff626f0dab3e05cbaffbae8502d5afc1c33b68
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>Insert title here</title>
</head>
<body>
	<h1>여기는 싸피 11기 대전8반 게시판입니다.</h1>
	<c:if test="${empty loginInfo}">
		<form action="${root}/user/login" method="post">
			ID: <input type="text" name="userId" value="ssafy"><br>
			PW: <input type="password" name="userPw" value="1234"><br>
			<input type="submit" value="LOGIN">
=======
<title>Header.jsp</title>
</head>
<body>
	<h1>대전 8반 게시판</h1>
	<c:if test="${empty loginInfo}">
		<form action="${root}/user/login" method="post">
			ID: <input type="text" name="userId" value="ssafy"><br>
			PW: <input type="password" name="userPw" value="ssafy"><br>
			<input type="submit" value="로그인">
>>>>>>> ecff626f0dab3e05cbaffbae8502d5afc1c33b68
		</form>
	</c:if>
	
	<c:if test="${not empty loginInfo}">
<<<<<<< HEAD
		안녕하세요*^^* <b>${loginInfo.userName}</b>(${loginInfo.userId}) 님 반갑습니다!
		<a href="${root}/user/logout">[로그아웃]</a>
=======
		안녕하세요~ ${loginInfo.userName}(${loginInfo.userId}) 님 반갑습니다!
		<a href="${root}/user/logout">[ 로그아웃 ]</a>
>>>>>>> ecff626f0dab3e05cbaffbae8502d5afc1c33b68
	</c:if>
</body>
</html>