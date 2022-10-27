<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>
	$(document).ready(function(){
		$('.btn_write').click(function(event){
			location.href = '${contextPath}/board/write.do';
		});
	});	
</script>
</head>
<body>

	<table border="1">
		<caption>총 게시글 : ${count}개</caption>
		<thead>
			<tr>
				<td>순번</td>
				<td>작성자</td>
				<td>제목</td>
				<td>작성일</td>
			<tr>
		<tbody>
			<tr>
				<c:if test="${count == 0}">	
					<td colspan="4">게시물이 없습니다.</td>
				</c:if>
				<c:if test="${count != 0}">
					<td colspan="4">게시글이 있어!!</td>
				</c:if>
			</tr>
			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="4">
					<input type="button" value="새글작성" class="btn_write">
				</td>
			</tr>
		</tfoot>
	</table>
	
</body>
</html>