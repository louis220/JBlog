<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 공용 헤더 -->
	<h1> JBLOG</h1>
	
	<ul>
	<c:choose>
		<c:when test="${empty authMember }">
		<!-- 로그인 안된 경우 -->
			<li><a href="<c:url value="/users/join"/>">가입</a></li>
			<li><a href="<c:url value="/users/login"/>">로그인</a></li>
		</c:when>
		<c:otherwise>
		<!-- 로그인 된 경우 -->
			<li><a href="<c:url value="/users/logout"/>">로그아웃</a></li>
			<li><a href="<c:url value="/${authMember.id} "/>">내블로그</a></li>
		</c:otherwise>
	</c:choose>
	</ul>