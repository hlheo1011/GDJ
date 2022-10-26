<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${login == null}"> <!-- 회원가입이 안되었다면 로그인 폼을 보여주겠다. -->
	<div>
		<form method="post" action="${contextPath}/member/login.me">
			<div>
				<input type="text" name="id" placeholder="아이디">
			</div>
			<div>
				<input type="password" name="pw" placeholder="비밀번호">
			</div>
			<div>
				<button>로그인</button>
			</div>
		</form>
	</div>
	</c:if>
	
	<c:if test="${login != null}">	<!-- login이 null이 아니라면(로그인 성공이라면) -->
		<div>
			${login.name}님 어서오세요.	<!-- login이 가지고 있는 .name -->
			<input type="button" value="로그아웃" onclick="location.href='${contextPath}/member/logout.me';">	<!-- 곧바로 요청 -->
		</div>
	</c:if>

</body>
</html>