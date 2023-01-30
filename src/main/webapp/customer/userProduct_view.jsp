<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/customer/inc/user_top.jsp" %>
<main>
	<div class="container rounded border mt-5 mb-5 p-5">	
		<div class="d-flex p-5">
			<img class="col-md-6" src="${ctx}/uploadedFile/${pDto.pImage}" style="width:50%;">
			<div class="col-md-6 ms-5 mt-4">
				<h4>${pDto.pSpec}</h4>
				<h4 class="mt-3">${pDto.pName}</h4>
				<p class="mt-5">가격</p>
				<h4>${pDto.price}</h4>
				<p class="mt-3">포인트</p>
				<h4>${pDto.pPoint}</h4>
			</div>
		</div>
		<div class="d-flex justify-content-between">
			<a href="${ctx}/userProductList.do" class="btn btn-secondary ms-5">목록으로</a>
			<!-- 로그인 시 -->
			<c:if test="${sessionScope.isLogin !=null}">
				<a href="${ctx}/cartAdd.do?pNum=${pDto.pNum}&pQty=1&pSpec=${pDto.pSpec}&pCategory_fk=${pDto.pCategory_fk}" class="btn btn-success me-5">장바구니</a>
			</c:if>
			
			<!-- 아닐 시 -->
			<c:if test="${sessionScope.isLogin == null}">
		      <a href="javascript:alert('로그인이 필요합니다')" class="btn btn-success me-5">
		      	장바구니
		      </a>
	      </c:if>
		</div>
	</div>
</main>
<%@ include file="/customer/inc/user_bottom.jsp" %>