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

	<div>
		<form action="${contextPath}/member/register.me" method="post">	<!-- 추가할때, 수정할때는 post로 하자. -->
			<div>
				<input type="text" name="id" placeholder="아이디">	<!-- name 값을 안주면 이동을 안함! parameter 값임!! -->
			</div>
			<div>
				<input type="password" name="pw" placeholder="패스워드">	<!-- name의 기준은 필드값이랑 동일해야되고 , 필드값은 DB보고 해야한다. -->
			</div>
			<div>
				<input type="text" name="name" placeholder="이름">
			</div>
			<div>
				<input type="text" name="email" placeholder="이메일">
			</div>
			<div>
				<button>회원가입</button>
				<input type="reset" value="입력초기화">
			</div>
		</form>
	</div>

</body>
</html>