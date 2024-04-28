<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>알림</title>
</head>
<body>
	<%@include file="Header.jsp" %>
=======
<title>Alert.jsp</title>
</head>
<body>
	<%@include file="Header.jsp"%>
>>>>>>> ecff626f0dab3e05cbaffbae8502d5afc1c33b68
	
	<script type="text/javascript">
		alert('${msg}');
		location.href="${root}/";
	</script>
</body>
</html>