<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="../assets/js/jquery-3.6.1.min.js"></script>
<script>

	$(document).ready(function(){
	
		$('.btn_list').click(function(event){
			location.href = '${contextPath}/board/list.do'
		});
	});
	
</script>
</head>
<body>

	<form method="POST" action="${contextPath}/board/add.do">
		<table border="1">
			<tbody>
				<tr>
					<td>작성자</td>
					<td><input type="text" placeholder="작성자" name="writer" value="${writer}" readonly></td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text" placeholder="공지사항" name="title" value="${title}"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="10" cols="50" placeholder="공지사항입니다." name="content"></textarea>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" value="등록">
						<input type="button" value="목록" class="btn_list">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>