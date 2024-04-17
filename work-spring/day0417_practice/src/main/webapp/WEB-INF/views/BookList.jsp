<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BookList.jsp</title>
</head>
<body>
	<h1>책 목록</h1>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>isbn</th>
				<th>제목</th>
				<th>작성자</th>
				<th>가격</th>
			</tr>
		</thead>
		<c:if test="${not empty bookList}">
			<tbody>
				<c:forEach var="book" items="${bookList}">
					<tr>
						<td>${book.isbn}</td>
						<td><a href="<%=request.getContextPath()%>/book/selectOne?isbn=${book.isbn}">${book.title}</a></td>
						<td>${book.writer}</td>
						<td>${book.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</c:if>
		<c:if test="${empty bookList}">
			<span>등록된 책이 없습니다.</span>
		</c:if>
	</table>
	<a href="<%=request.getContextPath()%>/">[ 메인화면 ]</a>
	<a href="<%=request.getContextPath()%>/book/add">[ 도서 추가 ]</a>
</body>
</html>