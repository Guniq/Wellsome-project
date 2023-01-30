<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="/customer/inc/user_top.jsp" %>
<main>
	<div class="ms-5 mt-5">
		<c:set property="spec" var="String" value="${requestScope.pdSpecs}"/>
		<div class="ms-5 mt-5">
			<h4 class="mt-5 mb-3">웰썸제품</h4>
			<h4 class="mt-3 mb-5" style="font-size:20px;color:#808080; font-weight:small">반려동물을 위한 건강하고 맛있는 식사의 시작</h4>
			<c:forEach var="ps" items="${pdSpecs}">
				<a class="btn btn-secondary" 
				href="${ctx}/userSpecList.do?pSpec=${ps.name()}">
					${ps.getValue()}
				</a>
			</c:forEach>
			<hr class="" style="width:100vh; border:1px solid #black;">
		</div>
		<div class="ms-5 mt-5 mb-5">
			<c:if test="${dtos == null || dtos.size() == 0 }">
				<p colspan='8'>상품이 존재하지 않습니다!!</p>
			</c:if>
			<div class="d-flex">
				<c:set var="cnt" value="0"/>	
					<c:if test="${dtos != null || dtos.size() != 0 }">
						<c:forEach var="dto" items="${requestScope.dtos}">
			    			<%@ include file="prod_loop.jsp" %>
			    		</c:forEach>
		    		</c:if>
  			</div>
		</div>
	</div>
</main>
<%@ include file="/customer/inc/user_bottom.jsp" %>