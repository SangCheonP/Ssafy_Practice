<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 추가 화면</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/book/add" method="post">
        
        <table border="1">
            <tr>
                <td>책제목:</td>
                <td><input type="text" name="title"></td>
            </tr>
            <tr>
                <td>작성자:</td>
                <td><input type="text" name="writer"></td>
            </tr>
            <tr>
                <td>가격:</td>
                <td><input type="number" name="price"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="작성완료">
                </td>
            </tr>
        </table>
    </form>

</body>
</html>