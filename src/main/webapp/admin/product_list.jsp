<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%@ include file="/admin/inc/admin_top.jsp" %>
<c:if test="${requestScope.msg != null}">
	<script>
		alert("${msg}");
	</script>
</c:if>
<main>
	<div class="container w-50">
		<div class="mt-5 border shadow-sm p-5">
			<h4 class="mt-5 mb-3">상품리스트</h4>
			<table class="table">
				<thead>
					<tr>
						<th>번호</th>
						<th>카테고리코드</th>
						<th>이미지</th>
						<th>상품명</th>
						<th>가격</th>
						<th>수량</th>
						<th>수정/삭제</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${dtos == null || dtos.size() == 0 }">
					<tr>
						<td colspan='8'>상품이 존재하지 않습니다!!</td>
					</tr>
				</c:if>
				<c:if test="${dtos != null || dtos.size() != 0 }">
					<c:forEach var="dto" items="${requestScope.dtos}">
					<tr>
						<td>${dto.pNum}</td>
						<td>${dto.pCategory_fk}</td>
						<td>
							<c:set var="imgPath" value="${ctx}/uploadedFile/${dto.pImage}"/>
							<img src="${imgPath}" style="width:60px"/>
						</td>
						<td>${dto.pName}</td>
						<td>${dto.price}</td>
						<td>${dto.pQty}</td>
						<td>
							<a href="${ctx}/productUpdate.do?pNum=${dto.pNum}" class="btn btn-sm btn-outline-success">수정</a>
							<a href="javascript:pdDel('${dto.pNum}', '${dto.pImage}')" 
							   class="btn btn-sm btn-danger">삭제</a>
						</td>
					</tr>
					</c:forEach>
				</c:if>
				</tbody>
			</table>
		</div>
	</div>
</main>
<script>
	function pdDel(pNum, pImage){
		var isDel = window.confirm("삭제 하시겠습니까?");
		if(isDel) location.href="${ctx}/productDelete.do?pNum="+pNum+"&pImage="+pImage;
	}
</script>
<%@ include file="/admin/inc/admin_bottom.jsp" %>