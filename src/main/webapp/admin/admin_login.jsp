<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/admin/inc/admin_top.jsp" %>

<c:if test="${requestScope.msg != null}">
	<script>
		alert("${msg}");
	</script>
</c:if>

<body>
	<div class="container border shadow-sm mt-5 p-5" style="width:60vh">
		<h3 class="p-3"><b>관리자 로그인</b></h3>
		<form action="adminLoginOk.do" method="post" name="ad_loginFrm">
			<table class="table table-borderless">
				<tr class="mt-3">
					<td>
						<input class="mt-3 form-control" type="text" id="id" name="id" placeholder="아이디"/>
						<input class="mt-2 mb-3 form-control" type="text" id="pw" name="pw" placeholder="비밀번호"/>
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" class="col-sm-12 col-md-12 mt-3 mb-3 btn btn-dark" 
						style="height:50px;" value="로그인" onclick="ad_loginChk()"/>
					</td>
				</tr>
			</table>				
		</form>
	</div>
</body>


<script>
	function ad_loginChk(){
		if(!ad_loginFrm.id.value){
			alert("아이디를 입력하세요!");
			ad_loginFrm.id.focus();
			return;
		}
		if(!ad_loginFrm.pw.value){
			alert("비밀번호를 입력하세요!");
			ad_loginFrm.pw.focus();
			return;
		}
		ad_loginFrm.submit();
	}
</script>
<%@ include file="/admin/inc/admin_bottom.jsp" %>

