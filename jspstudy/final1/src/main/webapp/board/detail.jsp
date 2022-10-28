<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.boardNo}번 게시글</title>
</head>
<body>
	
		<form method="POST" action="${contextPath}/board/modify.do">
		<table border="1">
			<tbody>
				<tr>
					<td>순번</td>
					<td>${board.boardNo}</td>
				</tr>
				<tr>
					<td>작성자</td>
					<td>${board.writer}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input type="text">${board.title}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea rows="10" cols="50">${board.content}</textarea>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="button" value="수정" class="btn_edit">
						<input type="button" value="목록" class="btn_list">
						<input type="button" value="삭제" class="btn_remove">
					</td>
				</tr>
			</tfoot>
		</table>
	</form>
	
</body>
</html>