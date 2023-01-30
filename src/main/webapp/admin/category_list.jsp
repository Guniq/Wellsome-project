<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/admin/inc/admin_top.jsp" %>
<c:if test="${requestScope.msg != null}">
	<script>
		alert("${msg}");
	</script>
</c:if>
<main>    
	<div class="container mt-5 w-50">
		<div class="border shadow-sm p-5">
			<h4 class="mt-5 mb-3">카테고리 리스트</h4>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>코드</th>
						<th>카테고리명</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.num}</td>
						<td>${dto.code}</td>
						<td>${dto.name}</td>
						<td><a href="${ctx}/categoryDelete.do?num=${dto.num}" class="btn btn-outline-danger btn-sm">삭제</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
<%@ include file="/admin/inc/admin_bottom.jsp" %>