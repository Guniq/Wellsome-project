<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/admin/inc/admin_top.jsp" %>
<c:if test="${requestScope.msg != null}">
	<script>
		alert("${sessionScope.name}${msg}");
	</script>
</c:if>
<main>
	<div class="container">
		<h3 class="p-5">ADMIN PAGE</h3>
	</div>
</main>
<%@ include file="/admin/inc/admin_bottom.jsp" %>
