<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardPage</title>
</head>
<body>
	<%@ include file="Header.jsp" %>
	
	<table border="1">
		<tr>
			<th>bno.</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일시</th>
			<th>조회수</th>
		</tr>
		<c:if test="${empty pageInfo or empty pageInfo.boardList}">
			<tr>
				<td colspan="5">작성된 게시글이 없습니다. 게시글을 작성해보세요</td>
			</tr>
		</c:if>
		<c:if test="${not empty pageInfo and not empty pageInfo.boardList}">
			<c:forEach var="b" items="${pageInfo.boardList}">
				<tr>
					<td>${b.bno}</td>
					<td><a href="${root}/board/read?bno=${b.bno}">${b.title}</a></td>
					<td>${b.writer}</td>
					<td>${b.writeDate}</td>
					<td>${b.readCount}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
	
	<div>
		<c:if test="${pageInfo.startPage>1}">
			<a href="${root}/board/list?page=${pageInfo.startPage-1}">[이전]</a>
		</c:if>
	
		<c:forEach begin="${pageInfo.startPage}" end="${pageInfo.endPage}" var="p">
			<a href="${root}/board/list?page=${p}"> ${p} </a>
		</c:forEach>
		
		<c:if test="${pageInfo.endPage < pageInfo.totalPage}">
			<a href="${root}/board/list?page=${pageInfo.endPage+1}">[다음]</a>
		</c:if>
	</div>
	
	<a href="${root}/board/write">[글쓰기]</a>
</body>







</html>