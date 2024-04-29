<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="root" value="<%=request.getContextPath()%>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인 메인 페이지</h1>
	<c:if test="${empty loginInfo}">
		<form action="${root}/user/login" method="post">
			ID: <input type="text" name="userId" value="ssafy"><br>
			PW: <input type="password" name="userPw" value="ssafy"><br>
			<input type="submit" value="LOGIN">
		</form>
	</c:if>
	
	<c:if test="${not empty loginInfo}">
		안녕하세요*^^* <b>${loginInfo.userName}</b>(${loginInfo.userId}) 님 반갑습니다!
		<a href="${root}/user/logout">[로그아웃]</a>
	</c:if>
</body>
</html>