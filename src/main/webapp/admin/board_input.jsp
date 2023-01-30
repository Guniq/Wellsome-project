<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/admin/inc/admin_top.jsp" %>
<main>
	<div class="container border shadow-sm p-5 mt-5 mb-3" style="width:60vh">
		<h4 class="mt-3">공지사항 등록</h4>
		<form action="${ctx}/boardInputOk.do" method="post" name="board_inputFrm">
			<div class="mt-5 d-flex">
				<label class="w-25 me-3" for="bName">글쓴이</label>
				<input type="text" class="form-control" id="bName" name="bName"/>
			</div>
			<div class="mt-2 mb-3 d-flex">
				<label class="w-25 me-3" for="bTitle">제목</label>
				<input type="text" class="form-control" id="bTitle" name="bTitle"/>
			</div>
			<div class="mt-2 mb-3 d-flex">
				<label class="w-25 me-3" for="bContent">내용</label>
				<textarea class="form-control" id="bContent" name="bContent"></textarea>
			</div>
			<div class="text-center mt-5">			
				<input type="button" class="btn btn-dark" value="등록" 
						onclick = "inputCheck()"/>
				<input type="reset" value="취소" class="btn btn-outline-success"/>
			</div>
		</form>
	</div>
</main>
<script>
	function inputCheck(){
		if(!board_inputFrm.bName.value){ // bName의 값이 널이면 참
			alert("이름을 입력하세요!!!");
			board_inputFrm.bName.focus();
			return;
		}
		if(!board_inputFrm.bTitle.value){ // bTitle의 값이 널이면 참
			alert("제목을 입력하세요!!!");
			board_inputFrm.bTitle.focus();
			return;
		}
		if(!board_inputFrm.bContent.value){ // bContent의 값이 널이면 참
			alert("내용을 입력하세요!!!");
			board_inputFrm.bContent.focus();
			return;
		}
		
		document.board_inputFrm.submit();
	}
</script>

<%@ include file="/admin/inc/admin_bottom.jsp" %>