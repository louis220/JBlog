<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>글작성</h1>
	<form action="<c:url value="/post/write"/>" 
			method="POST">
	<table border=0 width=500>
		<tr>
			<td>제목</td><td><input type="text" name="name"></td>
			
		</tr>
		<tr>
			<td colspan=4>내용<textarea name="content" cols=60 rows=10></textarea></td>
		</tr>
		<tr>
		
			<td colspan=4 align=left><input type="submit" VALUE=" 포스트하기 "></td>
		</tr>
	</table>
	</form>
</body>
</html>