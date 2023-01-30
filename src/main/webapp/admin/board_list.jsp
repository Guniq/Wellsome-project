<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<%@ include file="/admin/inc/admin_top.jsp" %>    
<main>
	<div class="container border shadow-sm p-5 mt-5 mb-3" style="width:100vh">
	<h4 class="text-center mb-4">공지사항</h4>
		<table class="table table-border text-center">
			<thead class="table-success">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
					<th>수정/삭제</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="dto" items="${dtos}">
				<tr>
					<td>${dto.bNum}</td>
					<td>${dto.bTitle}</td>
					<td>${dto.bName}</td>
					<td>${dto.bDate}</td>
					<td>
						<a href="${ctx}/boardUpdate.do?bNum=${dto.bNum}" class="btn btn-sm btn-outline-success">수정</a>
						<a href="javascript:pdDel('${dto.bNum}')" 
						   class="btn btn-sm btn-danger">삭제</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="text-center">
			<a href="${ctx}/boardInput.do" class="btn btn-dark">글쓰기</a>
		</div>
	</div>
</main>
<script>
	function pdDel(bNum){
		var isDel = window.confirm("삭제 하시겠습니까?");
		if(isDel) location.href="${ctx}/boardDelete.do?bNum="+bNum;
	}
</script>
<%@ include file="/admin/inc/admin_bottom.jsp" %>