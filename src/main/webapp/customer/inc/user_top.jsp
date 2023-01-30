<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>                
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>                         
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"></script>
<title>웰썸_WELLSOME | 자연에서 나고 자란 재료로 만든 특별하고 건강한 제품</title>
<link href="${ctx}/image/파비콘.jpg" rel="shortcut icon" type="image/x-icon">
<script src="${ctx}/js/inputChk.js"></script>
<script src="${ctx}/js/chkout.js"></script>
</head>
<body>
	<nav class="navbar" style="background-color:#1a5c3e;">
	  <div class="container-fluid">
	    <a href="${ctx}" class="mt-3 ms-5"><img class="ms-2" src="${ctx}/image/new_logo (1).png"/></a>
	    <ul class="navbar-nav mt-3">
			<li class="nav-item d-flex me-5" style="font-size:20px;">
			  <c:if test="${sessionScope.isLogin == null}">
			  	<a class="nav-link active text-white p-3" href="${ctx}/userLogin.do">LOGIN</a>
			  </c:if>
			  <c:if test="${sessionScope.isLogin != null}">
			  	<a class="nav-link active text-white p-3" href="${ctx}/userLogout.do">LOGOUT</a>
			  </c:if>
			  <c:if test="${sessionScope.isLogin == null}">
			  	<a class="nav-link active text-white p-3" href="${ctx}/userJoin.do">JOIN</a>
			  </c:if>
			  <c:if test="${sessionScope.isLogin != null}">
			  	<a class="nav-link active text-white p-3" href="${ctx}/userLogout.do">MYPAGE</a>
			  </c:if>
			  <c:if test="${sessionScope.isLogin == null}">
			  	<a class="nav-link active text-white p-3" href="${ctx}/userLogin.do">CART</a>
			  </c:if>
			  <c:if test="${sessionScope.isLogin != null}">
			  	<a class="nav-link active text-white p-3" href="${ctx}/cartList.do">CART</a>
			  </c:if>
			  <c:if test="${sessionScope.isLogin == null}">
			  	<a class="nav-link active text-white p-3" href="${ctx}/userLogin.do">ORDER</a>
			  </c:if>
			  <c:if test="${sessionScope.isLogin != null}">
			  	<a class="nav-link active text-white p-3" href="${ctx}/cartBuy.do">ORDER</a>
			  </c:if>
			</li>
		</ul>
	  </div>
	  <div class="container-fluid">
	    <ul class="navbar-nav mt-2 mb-2">
			<li class="nav-item d-flex ms-5" style="font-size:20px;">
			  <a class="nav-link active text-white p-3" href="${ctx}/userProductList.do">웰썸제품</a>
			  <a class="nav-link active text-white p-3" href="${ctx}/customer/user_story.jsp">브랜드소개</a>
			  <a class="nav-link active text-white p-3" href="${ctx}/userBoard.do">NEWS</a>
			</li>
		</ul>
	  </div>
	</nav>
</body>
</html>