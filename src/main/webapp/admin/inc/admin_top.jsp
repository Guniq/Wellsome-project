<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>                                         
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>웰썸_WELLSOME | ADMIN</title>
<link href="${ctx}/image/파비콘.jpg" rel="shortcut icon" type="image/x-icon">
</head>
<body>
	<nav class="navbar" style="background-color:#1a5c3e;">
	  <div class="container-fluid">
	  <c:if test="${sessionScope.isLogin == null}">
	    <a href="${ctx}/adminLogin.do" class="mt-3 ms-5"><img class="ms-2" src="${ctx}/image/new_logo (1).png"/></a>
	  </c:if>
	  <c:if test="${sessionScope.isLogin != null}">
	    <a href="${ctx}/admin/admin_main.jsp" class="mt-3 ms-5"><img class="ms-2" src="${ctx}/image/new_logo (1).png"/></a>
	  </c:if>
	    <ul class="navbar-nav mt-3">
			<li class="nav-item d-flex me-5" style="font-size:16px;">
				<c:if test="${sessionScope.isLogin == null}">
				  <a class="nav-link active text-white p-3" href="${ctx}/adminLogin.do">관리자 로그인</a>
				  <a class="nav-link active text-white p-3" href="${ctx}/customer/user_main.jsp">SHOP</a>
				</c:if>
				<c:if test="${sessionScope.isLogin != null}">
				  <a class="nav-link active text-white p-3" href="${ctx}/adminLogout.do">로그아웃</a>
				</c:if>
				<c:if test="${sessionScope.isLogin != null}">
				  <a class="nav-link active text-white p-3" href="${ctx}/customer/user_main.jsp">SHOP</a>
				  <a class="nav-link active text-white p-3" href="${ctx}/categoryInput.do">카테고리 등록</a>
				  <a class="nav-link active text-white p-3" href="${ctx}/categoryList.do">카테고리 리스트</a>
				  <a class="nav-link active text-white p-3" href="${ctx}/productInput.do">상품 등록</a>
				  <a class="nav-link active text-white p-3" href="${ctx}/productList.do">상품 리스트</a>
				  <a class="nav-link active text-white p-3" href="${ctx}/boardList.do">공지사항</a>
				</c:if>
			</li>
		</ul>
	  </div>
	</nav>
</body>
</html>