<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<jsp:include page="../layout/header.jsp">
	<jsp:param value="${blog.blogNo}번 블로그" name="title"/>
</jsp:include>

<style>
	.blind {
		display: none;
	}
</style>

<div>

	<h1>${blog.title}</h1>
	
	<div>
		<span>▷ 작성일 <fmt:formatDate value="${blog.createDate}" pattern="yyyy. M. d HH:mm" /></span>
		&nbsp;&nbsp;&nbsp;
		<span>▷ 수정일 <fmt:formatDate value="${blog.modifyDate}" pattern="yyyy. M. d HH:mm" /></span>
	</div>
	
	<div>
		<span>조회수 <fmt:formatNumber value="${blog.hit}" pattern="#,##0" /></span>
	</div>
	
	<hr>
	
	<div>
		${blog.content}
	</div>
	
	<div>
		<form id="frm_btn" method="post">
			<input type="hidden" name="blogNo" value="${blog.blogNo}">
			<input type="button" value="수정" id="btn_edit_blog">
			<input type="button" value="삭제" id="btn_remove_blog">
			<input type="button" value="목록" onclick="location.href='${contextPath}/blog/list'">
		</form>
		<script>
			$('#btn_edit_blog').click(function(){
				$('#frm_btn').attr('action', '${contextPath}/blog/edit');
				$('#frm_btn').submit();
			});
			$('#btn_remove_blog').click(function(){
				if(confirm('블로그를 삭제하면 블로그에 달린 댓글을 더 이상 확인할 수 없습니다. 삭제하시겠습니까?')){
					$('#frm_btn').attr('action', '${contextPath}/blog/remove');
					$('#frm_btn').submit();
				}
			});
		</script> 
	</div>
	
	<hr>
	
	<span id="btn_comment_list">
		댓글
		<span id="comment_count"></span>개 
	</span>
	
	<hr>
	
	<div id="comment_area" class="blind">
		<div id="comment_list"></div>
		<div id="paging"></div>
	</div>
	
	<hr>
	
	
	<div>
		<form id="frm_add_comment">
			<div class="add_comment">
				<div class="add_comment_input">
					<input type="text" name="content" id="content" placeholder="댓글을 작성하려면 로그인 해 주세요">
				</div>
				<div class="add_comment_btn">
					<input type="button" value="작성완료" id="btn_add_comment">
				</div>
			</div>
			<input type="hidden" name="blogNo" value="${blog.blogNo}">
		</form>
	</div>
	
	<!-- 현재 페이지 번호를 저장하고 있는 hidden -->
	<input type="hidden" id="page" value="1">
	
	
	<script>
		
		// 함수 호출
		fn_commentCount();
		fn_switchCommentList();
		fn_addComment();
		fn_commentList();
		fn_changePage();
		fn_removeComment();
		fn_switchReplyArea();
		fn_addReply();
		
		// 전역 변수 page (모든 함수에서 사용 가능)
		var page = 1;
		
		
		// 함수 정의
		function fn_commentCount(){
			$.ajax({
				type: 'get',
				url: '${contextPath}/comment/getCount',
				data: 'blogNo=${blog.blogNo}',
				dataType: 'json',
				success: function(resData){		// resData = {"commentCount" : 개수}
					$('#comment_count').text(resData.commentCount);
				}
			});
			
		}
		
		function fn_switchCommentList(){
			$('#btn_comment_list').click(function(){
				$('#comment_area').toggleClass('blind');
			});
		}
		
		
		
		function fn_addComment(){
			$('#btn_add_comment').click(function(){
				if($('#comment').val() == ''){
					alert('댓글 내용을 입력하세요');
					return;	// ajax 실행을 막음
				}
				$.ajax({
					type: 'post',
					url: '${contextPath}/comment/add',
					data: $('#frm_add_comment').serialize(),
					dataType: 'json',
					success: function(resData){		// resData = {"isAdded", true}
						if(resData.isAdd){
							alert('댓글이 등록되었습니다.');
							$('#content').val('');
							fn_commentList();	// 댓글 목록 가져와서 뿌리는 함수
							fn_commentCount();	// 댓글 목록 개수 갱신하는 함수
						}
						
					}
				})
			});
		}
		
		function fn_commentList(){
			$.ajax({
				type: 'get',
				url: '${contextPath}/comment/list',
				data: 'blogNo=${blog.blogNo}&page=' + $('#page').val(),	// page도 넘겨줘야함
				dataType: 'json',
				success: function(resData){
					/*
						resData = {
							"commentList": [
								{댓글하나},
								{댓글하나},
								...
							],
							"pageUtil": {
								page: x,
								...
							}
						}
					*/
					// 화면에 댓글 목록 뿌리기
					$('#comment_list').empty();	// 댓글 초기화
					$.each(resData.commentList, function(i, comment){	// 반복문 (인덱스와, 변수명(댓글 하나하나))
						var div = '';
						if(comment.depth == 0){
							div += '<div>';
						} else {
							div += '<div style="margin-left: 40px;">';
						}
						if(comment.state == 1) {
							div += '<div>';
							// 정상적인 댓글 보여주기
							div += comment.content;
							// 작성자만 삭제할 수 있도록 if 처리 필요
							div += '<input type="button" value="삭제" class="btn_comment_remove" data-comment_no="' + comment.commentNo + '">';
							// 답글만 답글을 달 수 있도록 if 처리(depth가 0이면 댓글, depth가 1이면 답글)
							if(comment.depth == 0){
								div += '<input type="button" value="답글" class="btn_reply_area">';								
							}
							div += '</div>'
						} else {
							if(comment.depth == 0) {
								div += '<div>삭제된 댓글입니다.</div>';
							} else {
								div += '<div>삭제된 답글입니다.</div>';
							}
						}
						div += '<div>';
						moment.locale('ko-KR');
						div += '<span style="font-size: 12px; color: silver;">' + moment(comment.createDate).format('YYYY. MM. DD hh:mm') + '</span>';	// js폴더 안의 moment-with-locales (시간 설정 라이브러리)
						div += '</div>';
						div += '<div style="margin-left: 40px;" class="reply_area blind">';	// reply_area를 toggle 시켜준다.
						div += '<form class="frm_reply">';  // form에다가 id 줄 수 없다. 여기는 반복문 안이기 때문에..!
						div += '<input type="hidden" name="blogNo" value="' + comment.blogNo + '">';
						div += '<input type="hidden" name="groupNo" value="' + comment.commentNo + '">';
						div += '<input type="text" name="content" placeholder="답글을 작성하려면 로그인을 해주세요">';
						// 로그인한 사용자만 볼 수 있도록 if 처리
						div += '<input type="button" value="답글작성완료" class="btn_reply_add">';	// ajax이기때문에 submit이 아니다. submit은 mvc하겠다는 소리이다.
						
						div += '</form>';
						div += '</div>';
						div += '</div>';
						$('#comment_list').append(div);
						$('#comment_list').append('<div style="border-bottom: 1px dotted gray;"></div>');	// 점선
						
						
					});
					// 페이징
					$('#paging').empty();
					var pageUtil = resData.pageUtil;
					var paging = '';
					// 이전 블록
					if(pageUtil.beginPage != 1) {
						paging += '<span class="enable_link" data-page="'+ (pageUtil.beginPage - 1) +'">◀</span>';
					}
					// 페이지번호
					for(let p = pageUtil.beginPage; p <= pageUtil.endPage; p++) {
						if(p == $('#page').val()){
							paging += '<strong>' + p + '</strong>';
						} else {
							paging += '<span class="enable_link" data-page="'+ p +'">' + p + '</span>';
						}
					}
					// 다음 블록
					if(pageUtil.endPage != pageUtil.totalPage){
						paging += '<span class="enable_link" data-page="'+ (pageUtil.endPage + 1) +'">▶</span>';
					}
					$('#paging').append(paging);
				}
			});
		}	// fn_commentList
		
		
		function fn_changePage(){
			$(document).on('click', '.enable_link', function(){	// js로 만든 애는 $(.enable_link)를 하지 못한다. (링크를 주지 못한다) js로 만든 동적 버튼은 이벤트를 이런식으로 줘야 한다.
				$('#page').val( $(this).data('page') );
				fn_commentList();
			});
		}
		
		function fn_removeComment(){
			$(document).on('click', '.btn_comment_remove', function(){
				if(confirm('삭제된 댓글은 복구할 수 없습니다. 댓글을 삭제할까요?')){
					$.ajax({
						type: 'post',
						url: '${contextPath}/comment/remove',
						data: 'commentNo=' + $(this).data('comment_no'), // .btn_comment_remove의 data-comment_no 속성을 줌.
						dataType: 'json',
						success: function(resData){	// resData = {"isRemove": true}
							if(resData.isRemove){
								alert('댓글이 삭제되었습니다.');
								fn_commentList();
								fn_commentCount();
							}
							
						}
					});
				}
			});
		}	// fn_removeComment
		
		
		function fn_switchReplyArea(){
			$(document).on('click', '.btn_reply_area', function(){
				$(this).parent().next().next().toggleClass('blind');
			});
		}
		
		function fn_addReply(){
			$(document).on('click', '.btn_reply_add', function(){
				if($(this).prev().val() == ''){
					alert('답글 내용을 입력하세요.');
					return;
				}
				$.ajax({
					type: 'post',
					url: '${contextPath}/comment/reply/add',
					data: $(this).closest('.frm_reply').serialize(), // 이건 안됨니다 $('.frm_reply').serialize(), form이 많아서 안됨
					dataType: 'json',
					success: function(resData){	// resData = {"isAdd", true}
						if(resData.isAdd){
							alert('답글이 등록되었습니다.');
							fn_commentList();
							fn_commentCount();
						}
					}
					
				})
			});
		}
		
		
	
	</script>
	
	
	
	
	
	
	


</div>

</body>
</html>