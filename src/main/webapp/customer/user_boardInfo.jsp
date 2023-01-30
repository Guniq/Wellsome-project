<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<%@ include file="/customer/inc/user_top.jsp" %>
<main>
	<div class="container mt-5 mb-5">	
		<input type="hidden" name="bNum" value="${dto.bNum}"/>
		<h4 class="text-center">공지사항</h4>
		<hr class="container" style="width:15vh; border:1px solid #1a5c3e;">
		<div class="container text-center" style="width:100vh">
			<h2 class="mb-3">${dto.bTitle}</h2>
			<p class="mb-5"><b>BY . ${dto.bName}</b></p>
			<p class="mt-5">${dto.bContent}</p>
			<a href="userBoard.do" class="btn btn-sm btn-secondary mt-5 mb-5">목록으로</a>
		</div>
	</div>
</main>
<%@ include file="/customer/inc/user_bottom.jsp" %>