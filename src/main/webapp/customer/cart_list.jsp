<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/customer/inc/user_top.jsp" %>

<main>
	<div class="mt-5 mb-5 d-flex">
		<section class="container mt-5">
			<h4>장바구니 리스트</h4>
			<table class="table mt-5">
				<thead>
					<tr>
						<th>상품사진</th>
						<th>상품명</th>
						<th>수량</th>
						<th>판매가</th>
						<th>합계</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
				<c:if test="${requestScope.pDtos ==null || requestScope.pDtos.size() ==0 }">
					<tr><td colspan='6'>장바구니가 비었습니다!!</td></tr>
				</c:if>
				<c:if test="${requestScope.pDtos !=null || requestScope.pDtos.size() !=0 }">
					<c:forEach var="pDto" items="${requestScope.pDtos}">
						<c:set var="cartTotPrice" value="0"/>
						<c:set var="cartTotPoint" value="0"/>
						<tr>
							<td>
								<a href="prodView.do?pNum=${pDto.pNum}&pSpec=${pDto.pSpec}">
								<img src="${ctx}/uploadedFile/${pDto.pImage}" width="80px"/>
								</a>
							</td>
							<td>${pDto.pName}</td>
							<td>
								<form action="${ctx}/cartUpdate.do" method="post">
									<input type="text" size="3" name="pQty" value="${pDto.pQty}"/>개<br/>
									<input type="hidden" name="pNum" value="${pDto.pNum}"/>
									<input type="submit" class="btn btn-sm btn-secondary mt-3" value="수정"/>
								</form>
							</td>
							<td>
								<fmt:formatNumber type="Number" value="${pDto.price}"/>원<br/>
								<fmt:formatNumber type="Number" value="${pDto.pPoint}"/>포인트
							</td>
							<td>
								<fmt:formatNumber type="Number" value="${pDto.totPrice}"/>원<br/>
								<fmt:formatNumber type="Number" value="${pDto.totPoint}"/>포인트
							</td>
							<td>
								<a href="${ctx}/cartDelete.do?pNum=${pDto.pNum}" class="btn btn-sm btn-danger">삭제</a>
							</td>
						</tr>
						<c:set var="cartTotPrice" value="${cartTotPrice + pDto.totPrice}"/>
						<c:set var="cartTotPoint" value="${cartTotPoint + pDto.totPoint}"/>
					</c:forEach>
				</c:if>	
				</tbody>
			</table>
			<!-- 장바구니 총액 표시 -->
			<div class="text-end">
				장바구니 총액 : <fmt:formatNumber type="Number" value="${cartTotPrice}"/>원<br/>
				총 포인트 : <fmt:formatNumber type="Number" value="${cartTotPoint}"/>포인트
			</div>
			<div class="text-center mt-5 mb-5">
			<c:if test="${requestScope.pDtos.size() ==0 }">
				<a href="javascript:alert('장바구니가 비었습니다!')" 
					class="btn btn-dark me-2">구매하기</a>
			</c:if>
			<c:if test="${requestScope.pDtos.size() !=0 }">
				<a href="${ctx}/cartBuy.do?cartTotPrice=${cartTotPrice}&cartTotPoint=${cartTotPoint}" 
					class="btn btn-dark me-2">구매하기</a>
			</c:if>
				<a href="${ctx}/userProductList.do" class="btn btn-outline-success">계속 쇼핑하기</a>
			</div>
		</section>
	</div>
</main>

<%@ include file="/customer/inc/user_bottom.jsp" %>