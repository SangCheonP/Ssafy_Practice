<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림</title>
</head>
<body>
	<%@include file="Header.jsp" %>
	
	<script type="text/javascript">
		alert('${msg}');
		location.href="${root}/";
	</script>
</body>
</html>