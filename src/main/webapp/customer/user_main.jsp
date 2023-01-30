<%@page import="wellsome.util.ProdSpec"%>
<%@page import="wellsome.model.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="wellsome.model.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/customer/inc/user_top.jsp" %>
<main>
	<div id="demo" class="carousel slide" data-bs-ride="carousel">
		
		 <!-- The slideshow/carousel -->
		 <div class="carousel-inner">
		   <div class="carousel-item active" data-bs-interval="3000">
		     <img src="${ctx}/image/main_section_1_img1 (1).jpg" alt="..." class="d-block w-100">
		   </div>
		   <div class="carousel-item">
		     <img src="${ctx}/image/main_section_1_img2 (2).jpg"  alt="..." class="d-block w-100">
		   </div>
		   <div class="carousel-item">
		     <img src="${ctx}/image/main_section_1_img3 (1).jpg" alt="..." class="d-block w-100">
		   </div>
		   <div class="carousel-item">
		     <img src="${ctx}/image/main_section_1_img4 (1).jpg" alt="..." class="d-block w-100">
		   </div>
		   <div class="carousel-item">
		     <img src="${ctx}/image/terrin.jpg" alt="..." class="d-block w-100">
		   </div>
		 </div>
		
		 <!-- Left and right controls/icons -->
		  <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
		    <span class="carousel-control-prev-icon"></span>
		  </button>
		  <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
		    <span class="carousel-control-next-icon"></span>
		  </button>
	</div>
	
	<div class="p-5 mt-5 mb-5">
		<h2 class="ms-5 mt-5 mb-3"style="color:#1a5c3e;">The special products of nature</h2>
		<h1 class="ms-5 mb-5" style="color:#1a5c3e;"><b>자연에서 나고 자란 재료로 만든 특별하고 건강한 제품</b></h1>
		<h4 class="ms-5 mt-5" style="color:#a4a4a4; font-weight:small">모든 반려동물은 성장 단계와 건강 상태에 따라 변화되는 영양학적 요구에 맞는 음식을 섭취해야합니다.<br/>
		웰썸은 자연에서 얻은 신선한 원료로 만든 건강한 반려동물 사료 & 간식 브랜드 입니다.</h4>
	</div>
	<div class="mt-5 mb-5" style="background-image:url('${ctx}/image/brand_story.png'); height:50vh">
		<%-- <img src="${ctx}/image/brand_story.png" class="d-block w-100"> --%>
		<div class="p-5">
			<h2 class="ms-5 mt-3" style="color:#eee;">BRAND STORY</h2>
			<h1 class="ms-5" style="color:#eee;"><b>자연이 전하는 특별함</b></h1>
			<h4 class="ms-5 mt-4" style="color:#eee; font-weight:small">‘WELL’과 ‘WHOLESOME’의 합성어인 “WELLSOME”은 </br>
																	사랑하는 반려동물의 건강과 맛만을 생각하여 자연의 재료만을담아 더 안심하고 먹을 수 있는</br>
																	친환경 반려동물 사료&간식 브랜드입니다.</h4>
			<a href="${ctx}/customer/user_story.jsp" class="ms-5 mt-5 btn btn-light btn-lg" style="width:150px; height:50px">더보기</a>
		</div>
	</div>
</main>

<%@ include file="/customer/inc/user_bottom.jsp" %>


