<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1" width="640">
		
		<tr>
			<th>번호</th>
			<th>카테고리명</th>
			<th>포스트수</th>
			<th>설명</th>
			<th>삭제</th>
			
		</tr>
		<!-- loop -->
		<c:forEach items="${list }" var="vo">
		<tr>
			<td>${vo.cateNo }</td>
			<td>${vo.cateName }</td>
			<td></td>
			<td>${vo.description }</td>
			
			<td>
			<form method="post"
				action="<c:url value="/${authMember.id}/admin/delete"/>">
				<input type='hidden' name="cateNo" value="${vo.cateNo }">
					<input type="submit" value="삭제"><br>
				</form>
			</td>
		</tr>
		</c:forEach>
		
	</table>
	
	<br>
	<br>
	
	
	<form method="post" action="<c:url value="/${authMember.id}/admin/category"/>">
		<table border="1" width="640">
			<tr>
				<td colspan="2"><h3>새로운 카테고리 추가</h3></td>
			</tr>
			
			<tr>
				<td>카테고리명</td>
				<td><input type="text" name="cateName" value=""></td>
			</tr>
			<tr>
				<td>설명</td>
				<td>
					<textarea id="content" name="description"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
				</td>	
			</tr>
		</table>
	</form>

</body>
</html>