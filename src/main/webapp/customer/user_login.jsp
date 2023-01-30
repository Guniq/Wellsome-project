<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<c:set var="ctx" value="${pageContext.request.contextPath}"/>  
<c:if test="${requestScope.msg != null}">
	<script>
		alert("${msg}");
	</script>
</c:if>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>
<title>웰썸_WELLSOME | 자연에서 나고 자란 재료로 만든 특별하고 건강한 제품</title>
<link href="${ctx}/image/파비콘.jpg" rel="shortcut icon" type="image/x-icon">
</head>
<body>
	<div class="container mt-5 p-5" style="width:60vh">
		<div style="border-bottom: 1px solid #efefef;">
			<a href="${ctx}" class="ms-auto btn btn-outline-secondary">뒤로가기</a>
			<h3 class="mb-5 text-center" style="color:#1a5c3e;"><b>WELLSOME</b></h3>
		</div>
		<h3 class="p-3 mt-5"><b>로그인</b></h3>
		<form action="${ctx}/userLoginOk.do" method="post" name="loginForm">
			<table class="table table-borderless">
				<tr>
					<td>
						<input class="mt-5 form-control mb-1" type="text" name="id" placeholder="아이디"/>
						<input class="mb-3 form-control" type="password" name="pw" placeholder="비밀번호"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" class="col-sm-12 col-md-12 mt-5 mb-3 btn btn-dark" style="height:50px;" onclick="inputChk()" value="로그인"/>
					</td>
				</tr>
				<tr>
					<td style="position:relative;">
						<a href="${ctx}/userJoin.do" class="text-dark text-decoration-none" style="font-weight:600; font-size:20px; position:absolute; right:20px;">가입하기</a>
					</td>
				</tr>
			</table>				
		</form>
	</div>
	
<script>
	function inputChk(){
		if(document.loginForm.id.value.length == ''){
			alert("아이디를 입력해주세요!");
			loginForm.id.focus();
			return;
		}
		if(document.loginForm.pw.value.length == ''){
			alert("비밀번호를 입력해주세요!");
			loginForm.pw.focus()
			return;
		}
		
		document.loginForm.submit();
	}
</script>
</body>
</html>

