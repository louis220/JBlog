<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<h1> ${authMember.userName }의 블로그입니다.</h1>
	
	<ul>
	<c:choose>
		<c:when test="${empty authMember }">
		<!-- 로그인 안된 경우 -->
			<li><a href="<c:url value="/users/login"/>">로그인</a></li>
		</c:when>
		<c:otherwise>
		<!-- 로그인 된 경우 -->
			<li><a href="<c:url value="/${authMember.id}/admin/basic"/>">내블로그 관리</a></li>
			<li><a href="<c:url value="/users/logout"/>">로그아웃</a></li>
			
			<li><a href="<c:url value="/${authMember.id}/admin/basic"/>">기본설정</a></l1>
			<li><a href="<c:url value="/${authMember.id}/admin/category"/>">카테고리</a></li>
			<li><a href="<c:url value="/${authMember.id}/admin/write"/>">글작성</a></li>
			
			
			
		</c:otherwise>
	</c:choose>
	</ul>

	<form id="title-form" 
		name="titleform" 
		method="POST" 
		action="<c:url value="/users/login"/>">
		
		<label class="block-label" for="blogTitle">블로그 제목</label> 
		<input id="blogTitle" name="blogTitle" type="text" value=""> 
		<br>


		<input type="submit" value="기본설정변경">
	
	
	
	
	