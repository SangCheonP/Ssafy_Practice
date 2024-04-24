<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<form action="${root}/board/write" method="post" enctype="multipart/form-data">
		제목 : <input type="text" name="title"><br> 
		내용 :
			<textarea rows="10" cols="20" name="content"></textarea><br>
			<button id="btnAddFile">파일추가</button>
<!-- 			<input type="button" value="파일추가"> -->
			<div id="fileArea"></div>
			 
			<input type="submit" value="작성완료">
	</form>
	
	<script type="text/javascript">
		document.getElementById('btnAddFile').onclick = function(){
			let f = '<input type="file" name="uploadedFiles">';
			document.getElementById('fileArea').innerHTML += f;
			return false; // button 태그에 submit 걸려있어서 글써져버리니까 submit 취소시키는 false
		}
	</script>
</body>
</html>