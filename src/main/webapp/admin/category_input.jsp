<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<c:set var="ctx" value="${pageContext.request.contextPath}"/>   

<%@ include file="/admin/inc/admin_top.jsp" %>
<main>
<div class="container border shadow-sm p-5 mt-5 mb-3" style="width:60vh">
	<h4 class="mt-3">카테고리 등록</h4>
	
	<form action="${ctx}/categoryInputOk.do" method="post" name="cat_inputFrm">
		<div class="mt-5 d-flex">
			<label class="me-3" for="code" style="width:150px">카테고리 코드</label>
			<input type="text" class="form-control" id="code" name="code"/>
		</div>
		<div class="mt-2 mb-3 d-flex">
			<label class="me-3" for="name" style="width:150px">카테고리명</label>
			<input type="text" class="form-control" id="name" name="name"/>
		</div>
		<div class="text-center mt-5">			
			<input type="button" class="btn btn-dark" value="등록" 
					onclick = "inputCheck()"/>
			<input type="reset" value="취소" class="btn btn-outline-success"/>
		</div>
	</form>
</div>
</main>
<script>
	function inputCheck(){
		if(!cat_inputFrm.code.value){ // code의 값이 널이면 참
			alert("카테고리 코드를 입력하세요!!!");
			cat_inputFrm.code.focus();
			return;
		}
		if(!cat_inputFrm.name.value){ // name의 값이 널이면 참
			alert("카테고리명을 입력하세요!!!");
			cat_inputFrm.name.focus();
			return;
		}
		
		document.cat_inputFrm.submit();
	}
</script>

<%@ include file="/admin/inc/admin_bottom.jsp" %>