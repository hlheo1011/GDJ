<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- Core Library --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
		속성(Attribute) 만들기 태그
		
		1. <c:set var="속성명" value="값" scope="영역">
		2. 영역 : page, request, session, application
	--%>
	
	<c:set var="name" value="홍길동" scope="page" />
	<c:set var="age" value="45" scope="page" />
	<c:set var="isAdult" value="${age >= 20}" scope="page" />
	<c:set var="height" value="180.5" scope="page" />
	<c:set var="weight" value="75.5" scope="page" />
	<c:set var="bmi" value="${weight div (height * height * 0.0001)}" scope="page" />
	<!-- height * height * 0.0001 = 키(m) * 제곱 -->
	<c:set var="health" value="${bmi ge 18.5 ? '비만' : '정상'}" scope="page" />
			
	<h1>이름 : ${name}</h1>
	<h1>나이 : ${age}</h1>
	<h1>${isAdult ? '성인' : '미성년자'}</h1>
	<h1>bmi : ${bmi}</h1>
	<h1>건상상태 : ${health}</h1>
	

</body>
</html>