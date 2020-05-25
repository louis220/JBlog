<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
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
			
		</c:otherwise>
	</c:choose>
	</ul>
	
	