<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookList.jsp</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>isbn</th>
			<th>제목</th>
			<th>작성자</th>
			<th>가격</th>
		<tr>
		<c:if test="${not empty bList}">
			<c:forEach items="${bList}" var="b">
				<tr>
					<td>${b.isbn}</td>
					<td>${b.title}</td>
					<td>${b.writer}</td>
					<td>${b.price}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>