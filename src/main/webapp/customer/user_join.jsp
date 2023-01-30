<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/customer/inc/user_top.jsp" %>    

<body>
	<div class="container w-50 p-5">
		<h3 class="text-center mt-5 mb-5"><b>회원 가입</b></h3>
		<h3 class="">기본정보</h3>
		<p class="text-end mt-3 mb-3"><img class="me-2" src="${ctx}/image/ico_required.gif">필수 입력사항</p>
		<form action="${ctx}/userJoinOk.do" method="post" name="joinForm">
			<div class="mt-3 mb-4 d-flex">
				<label class="w-25 mt-2" for="id">아이디<img class="ms-2" src="${ctx}/image/ico_required.gif"></label>
				<input type="text" class="form-control" id="id" placeholder="아이디" style="width:77vh" name="id"/>
				<input class="btn btn-outline-primary" type="button" value="중복확인" onclick="idChk()">
			</div>
			<hr style="border:1px solid #ced4da;">
			<div class="mt-3 mb-4 d-flex">
				<label class="w-25 mt-2" for="pw">비밀번호<img class="ms-2" src="${ctx}/image/ico_required.gif"></label>
				<input type="password" class="form-control" id="pw" placeholder="비밀번호" name="pw"/>
			</div>
			<hr style="border:1px solid #ced4da;">
			<div class="mt-3 mb-4 d-flex">
				<label class="w-25 mt-2" for="pwConfirm">비밀번호 확인<img class="ms-2" src="${ctx}/image/ico_required.gif"></label>
				<input type="password" class="form-control" id="pwConfirm" placeholder="비밀번호 확인" name="pwConfirm"/>
			</div>
			<hr style="border:1px solid #ced4da;">
			<div class="mt-3 mb-4 d-flex">
				<label class="w-25 mt-2" for="name">이름<img class="ms-2" src="${ctx}/image/ico_required.gif"></label>
				<input type="text" class="form-control" id="name" placeholder="이름" name="name"/>
			</div>
			<hr style="border:1px solid #ced4da;">
			<div class="mt-3 mb-4 d-flex">
				<label class="w-25 mt-2" for="tel">전화번호<img class="ms-2" src="${ctx}/image/ico_required.gif"></label>
				<input type="text" class="form-control" id="tel" placeholder="전화번호" name="tel"/>
			</div>
			<hr style="border:1px solid #ced4da;">
			<div class="mt-3 mb-4 d-flex">
				<label class="w-25 mt-2" for="email">이메일</label>
				<input type="text" class="form-control" id="email" placeholder="이메일" name="email"/>
			</div>
			<hr style="border:1px solid #ced4da;">
			<div class="mt-3 d-flex">
				<label style="width:20%;" class="mt-2" for="addr">주소</label>
				<input type="text" style="width:50%; border:1px solid #ced4da;" class="form-control ms-0" id="sample4_postcode" name="zipcode" placeholder="우편번호" readonly>
				<a class="btn btn-sm btn-secondary ms-3" style="width:8vh;" onclick="sample4_execDaumPostcode()">우편번호</a><br>
			</div>
			<div class="mt-3">
				<input style="width:80%; border:1px solid #ced4da;" class="form-control ms-auto mb-1" type="text" name="roadAddr" id="sample4_roadAddress" placeholder="도로명주소" readonly>
				<input style="width:80%; border:1px solid #ced4da;" class="form-control ms-auto" type="hidden" name="jibunAddr" id="sample4_jibunAddress" placeholder="지번주소" readonly>
				<input style="width:80%; border:1px solid #ced4da;" class="form-control ms-auto" type="text" id="sample4_detailAddress" name="detailAddr" placeholder="상세주소">
			</div>
			<hr style="border:1px solid #ced4da;">
			
			<div class="text-center">
				<input type="button" class="mt-3 mb-5 btn btn-lg btn-dark" value="회원가입" onclick="inputChk()"/>
			</div>
		</form>
	</div>	

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function sample4_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('sample4_postcode').value = data.zonecode;
                document.getElementById("sample4_roadAddress").value = roadAddr;
                document.getElementById("sample4_jibunAddress").value = data.jibunAddress; 
                
            }
        }).open();
    }
    function idChk(){
		if($("#id").val() ==''){
			alert("아이디를 입력하세요!!");
			$("#id").focus();
			return;
		}
		
		// 입력 id값
		var id = $("#id").val();		
		
		// jQuery에서 제공하는 ajax함수
		$.ajax({
			url:"<c:url value='/userIdCheck.do'/>", // 서버 요청 URL
			type: "post", // 전송방식
			data: {"id":id}, // key:value 형태의 JSON형식으로 서버에 보내는 Data를 의미
			success: duplicateChk, // 콜백함수
			error:	function(){
				alert("요청 실패!!!");
			}
		});
	}
	
	// 서버로 부터 전송된 응답 결과를 처리하는 함수, 매개변수 data: 서버 처리결과 데이터
	function duplicateChk(data){
		if(data !="N"){
			alert("이미 존재하는 아이디 입니다!!!");
			$("#id").focus();
		}else{
			alert("사용 가능한 아이디 입니다!!");
		}
	}
</script>
</body>
</html>
<%@ include file="/customer/inc/user_bottom.jsp" %>