<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/admin/inc/admin_top.jsp" %>
<main>
	<div class="container border shadow-sm mt-5 p-5" style="width:60vh">
		<form action="${ctx}/boardUpdateOk.do" method="post">
		<h4 class="mt-2 mb-5">공지사항 수정</h4>
			<input type="hidden" name="bNum" value="${dto.bNum}"/>
			<table class="table table-borderless">
				<tr>
					<td>글쓴이</td>
					<td>
						<input class="form-control-sm" type="text" name="bName" value="${dto.bName}" />
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td><input class="form-control" type="text" name="bTitle" value="${dto.bTitle}"/></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea class="form-control" name="bContent">${dto.bContent}</textarea></td>
				</tr>
				<tr>
					<td colspan="2" align="center" class="pt-5">
						<input type="submit" value="수정" class="btn btn-outline-success">
						<a href="javascript:pdDel('${dto.bNum}')" class="btn btn-danger">삭제</a>
						<a href="${ctx}/boardList.do" class="btn btn-outline-primary">리스트</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
</main>
<script>
	function pdDel(bNum){
		var isDel = window.confirm("삭제 하시겠습니까?");
		if(isDel) location.href="${ctx}/boardDelete.do?bNum="+bNum;
	}
</script>
<%@ include file="/admin/inc/admin_bottom.jsp" %>
