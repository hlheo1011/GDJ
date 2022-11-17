<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="${contextPath}/resources/js/jquery-3.6.1.min.js"></script>
<script>
	
	$(function(){
		fn_list();
		fn_add();
		fn_inquiry();
		fn_btn_list();
	});
	
	function fn_list(){
		$.ajax({
			type: 'get',
			url: '${contextPath}/list.json',
			dataType: 'json',
			success: function(resData){
				$('#list').empty();
				$.each(resData, function(i, staff){
				// $.each() 에서 첫번째 인수는 배열이 온다.
				// resData는 배열임.
			
					var tr = '<tr>';
					tr += '<td>' + staff.sno + '</td>';
					tr += '<td>' + staff.name + '</td>';
					tr += '<td>' + staff.dept + '</td>';
					tr += '<td>' + staff.salary + '</td>';
					tr += '</tr>';
					$('#list').append(tr);
					
					/*
					$('<tr>')
					.append( $('<td>').text(staff.sno) )
					.append( $('<td>').text(staff.name) )
					.append( $('<td>').text(staff.dept) )
					.append( $('<td>').text(staff.salary) )
					.appendTo('#list');
					*/
					
				});
			}
		});
	}
	
	
	function fn_add(){
		$('#btn_add').click(function(){		
			if( /^[0-9]{5}$/.test($('#sno').val()) == false) {
				alert('사원번호는 5자리 숫자입니다.');
				return;
			}
			if( /^[가-힇]{3,5}$/.test($('#dept').val()) == false){
				alert('부서는 3~5자리 한글입니다.');
				return;
			}
			$.ajax({
				type: 'post',
				url: '${contextPath}/add',
				// data: $('#frm_add').serialize(),
				data: 'sno=' + $('#sno').val() + '&name=' + $('#name').val() + '&dept=' + $('#dept').val(),
				// data = 파라미터
				dataType: 'text',
				success: function(resData){
					alert(resData);
					fn_list();
					// 입력된걸 지워주는 코드
					$('#sno').val('');
					// document.getElementById('sno').value = '';
				},
				error: function(jqXHR){
					alert(jqXHR.responseText);
				}
			});
		});
	}
	// success는 try에서 응답을 만들어준다.
	// error는 catch에서 응답을 만들어준다.
	
	
	function fn_inquiry(){
		$('#btn_query').click(function(){
			if( /^[0-9]{5}$/.test($('#query').val()) == false ) {
				alert('사원번호는 5자리 숫자입니다.');
				return;
			}
			$.ajax({
				type: 'get',
				url: '${contextPath}/listbyone.json',
				data: 'sno=' + $('#query').val(),
				dataType: 'json',
				success: function(resData){
					$('#list').empty();
						var tr = '<tr>';
						tr += '<td>' + resData.sno + '</td>';
						tr += '<td>' + resData.name + '</td>';
						tr += '<td>' + resData.dept + '</td>';
						tr += '<td>' + resData.salary + '</td>';
						tr += '</tr>';
						$('#list').append(tr);					
				},
				error: function(jqXHR){ 
					alert('조회된 사원 정보가 없습니다.');
				}
			});
		});
	}
	
	function fn_btn_list(){
		$('#btn_list').click(function(){
			fn_list();
		})
	}

   
		
	
	
</script>
</head>
<body>

	<h3>사원등록</h3>
	<form id="frm_add">
		<input type="text" id="sno" name="sno" placeholder="사원번호">
		<input type="text" id="name" name="name" placeholder="사원이름">
		<input type="text" id="dept" name="dept" placeholder="부서이름">
		<input type="button" value="등록" id="btn_add">
	</form>
	
	<hr>
	
	<h3>사원조회</h3>
	<input type="text" id="query" name="query">
	<input type="button" value="조회" id="btn_query">
	<input type="button" value="전체" id="btn_list">
	
	<hr>
	
	<h3>사원목록</h3>
	<table border="1">
		<thead>
			<tr>
				<td>사원번호</td>
				<td>사원명</td>
				<td>부서명</td>
				<td>연봉</td>
			</tr>
		</thead>
		<tbody id="list">
		</tbody>
	
	</table>
	

</body>
</html>