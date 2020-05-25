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
<h1>회원 가입</h1>
	<!-- TODO :가입버튼을 누르면 registerform안에 있는 값을 검증한 후에 전송 -->
	<c:url value="/users/join" var="joinUrl" />
	<form:form
		modelAttribute="memberVo"
		id="join-form"
		name="registerForm" 
		action="${joinUrl }"
		method="POST"
		>
		
		<label for="name">이름</label>
		<form:input path="userName" type="text" placeholder="이름을 입력하십시오"/>
		<!-- MemberVo 객체에 에러가 있는가? -->
		<spring:hasBindErrors name = "memberVo">
			<!-- 필드 에러 확인 -->
			<c:if test="${errors.hasFieldErrors('name') }">
				<span style="color:red">
				<spring:message code="${errors.getFieldError('name').codes[0] }"
								text="${errors.getFieldError('name').defaultMessage }"/>
				</span>
			</c:if>
		</spring:hasBindErrors>
		
		<br>
	<label for="id">아이디</label>
		<form:input type="text" path="id" placeholder="id를 입력하십시오." />
		<spring:hasBindErrors name = "memberVo">
			<!-- 필드 에러 확인 -->
			<c:if test="${errors.hasFieldErrors('id') }">
				<span style="color:red">
				<spring:message code="${errors.getFieldError('id').codes[0] }"
								text="${errors.getFieldError('id').defaultMessage }"/>
				</span>
			</c:if>
		</spring:hasBindErrors>
		
		<br>
		
		<label for="password">비밀번호</label>
		<form:input path="password" type="password" placeholder="비밀번호를 입력하십시오" />
		<spring:hasBindErrors name = "memberVo">
			<!-- 필드 에러 확인 -->
			<c:if test="${errors.hasFieldErrors('password') }">
				<span style="color:red">
				<spring:message code="${errors.getFieldError('password').codes[0] }"
								text="${errors.getFieldError('password').defaultMessage }"/>
				</span>
			</c:if>
		</spring:hasBindErrors>
		<br>
	
		
		<label for="agree">약관동의</label>
		<br>
		<input type="checkbox" name="agree">서비스 약관에 동의합니다.<br>
		<input type="submit" value="회원가입"> 
	
	</form:form>
</body>
<script>
$(document).ready(function(){
	//jquery 초기화
	//#btmcheckemail에 click 이벤트 부탁
	$("#btnCheckId").on("click", function(event){
		var email = document.registerForm.Id.value.trim();
		//alert("Email:" +email);
		//1차 검증
		if(Id.length == 0) {
			alert("아이디를 입력해 주세요.");
			return;
		}
		//ajax call
		$.ajax({
			url: "<c:url value="/users/checkId"/>",
			type: "GET",
			data: {id: id},
			dataType: "json",
			success: function(result){
				console.log("Result:", result);
				//result.exist 를 검정, 메세지를 출력
				if(result.exists){
					//중복된 이메일
					alert("이미 가입된 아이디입니다.");
				}else{
					alert("사용 가능한 아이디입니다.");
				}
				
			},
			error: function(request, status, error){
				console.error("Error:", error);
			}
		});
	});
	
	
});
</script>
</html>