<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="ctxPath" value="${pageContext.request.contextPath}"/>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal.memberVO" var="authInfo"/> <!-- 사용자 인증된 경우 위와같이 정의 -->
</sec:authorize>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Web Site</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<script>
	var ctxPath = '${ctxPath}';
	let duplicateLogin = '${duplicateLogin}';
	
	let csrfHeaderName = '${_csrf.headerName}';
	let csrfTokenValue = '${_csrf.token}';
	
	let memberId = '${authInfo.memberId}'; // 인증되 사용자의 계정
	let auth = '${authInfo.authList}'; // 인증된 사용자의 권한
	
	$(document).ajaxSend(function(e, xhr, options){
		xhr.setRequestHeader(csrfHeaderName,csrfTokenValue);
	})
	
	if(duplicateLogin) alert(duplicateLogin);
</script>
</head>

<body>
<nav class="navbar navbar-expand-sm bg-light justify-content-between">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="${ctxPath == '' ? '/': ctxPath}">Home</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="${ctxPath}/board/list">자유게시판</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">Link 3</a>
        </li>
    </ul>
	<ul class="navbar-nav">
		<sec:authorize access="isAnonymous()">
		<li class="nav-item">
			<a class="nav-link" href="${ctxPath}/join/step1">회원가입</a>
		</li>		
		<li class="nav-item">
			<a class="nav-link" href="${ctxPath}/login">로그인</a>
		</li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<li class="nav-item">
			  <a class="nav-link" href="${ctxPath}/myPage">마이페이지</a>
			</li>
			<form action="${ctxPath}/member/logout" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<li class="nav-item">
					<a class="nav-link logout" href="#">로그아웃</a>
				</li>
			</form>
		</sec:authorize>
	</ul>
</nav>

<script>

$(function(){
	$('.logout').click(function(e){
		e.preventDefault();
		$(this).closest('form').submit();
	});
});

</script>