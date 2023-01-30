<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
       
<c:set var="cnt" value="${cnt+1}"/>
<div class="card mt-5 <c:if test="${cnt%4 != 0}">me-5</c:if>" style="width:40vh">
	<a href="${ctx}/userProductView.do?pNum=${dto.pNum}" style="overflow:hidden;">
    	<img class="card-img-top" src="${ctx}/uploadedFile/${dto.pImage}" alt="Card image" 
    	style="width:100%;">
    </a>	
    <div class="mt-2 me-4" style="text-align:right;">
      <!-- 로그인이 되었을 경우 -->
      <c:if test="${sessionScope.isLogin !=null}">
      <a href="${ctx}/cartAdd.do?pNum=${dto.pNum}&pQty=1&pSpec=${dto.pSpec}&pCategory_fk=${requestScope.code}" 
      	class="" style="width:100%">
      	<img src="${ctx}/image/icon_202210242143372300 (1).png">
	  </a>
      </c:if>	
      
      <!-- 로그인이 안되었을 경우 -->
      <c:if test="${sessionScope.isLogin == null}">
      <a href="javascript:alert('로그인이 필요합니다')" style="width:100%;">
      	<img class="" src="${ctx}/image/icon_202210242143372300 (1).png" style="width:15%">
      </a>
      </c:if>	
    </div>
    <div class="">
	    <h4 class="ms-4 mb-3" style="overflow:hidden; text-overflow:ellipsis; 
		      	white-space:nowrap; text-align:left;"><b>${dto.pName}</b></h4>
	    <h3 class="me-4" style="color:#1a5c3e; text-align:right;">
	    	<fmt:formatNumber type="Number" value="${dto.price}"/> 원
	    </h3>
    </div>
</div> <!-- card div -->
<c:if test="${cnt%4 ==0}">
	</div><div class="d-flex mt-4">
</c:if>