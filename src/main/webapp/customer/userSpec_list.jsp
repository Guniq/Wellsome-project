<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/customer/inc/user_top.jsp" %>
<main>
	<div class="ms-5 mt-5">
		<div class="ms-5 mt-5">
		<h4 class="mt-5 mt-5 mb-5"> ${specValue} 상품</h4>
			<c:forEach var="ps" items="${pdSpecs}">
				<a class="btn btn-secondary" 
				href="${ctx}/userSpecList.do?pSpec=${ps.name()}">
					${ps.getValue()}
				</a>
			</c:forEach>
			<hr class="" style="width:100vh; border:1px solid #black;">
		</div>
	<c:if test="${dtos == null}">
		<h4 colspan='8'>상품이 존재하지 않습니다!!</h4>
	</c:if>	
	<div class="d-flex mb-5 p-5">
		<c:set var="cnt" value="0"/>	
			<c:if test="${dtos != null || dtos.size() != 0 }">
				<c:forEach var="dto" items="${requestScope.dtos}">
	    			<%@ include file="prod_loop.jsp" %>
	    		</c:forEach>
    		</c:if>
		</div>	
	</div>
</main>
<%@ include file="/customer/inc/user_bottom.jsp" %>