<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/admin/inc/admin_top.jsp" %>
<main>
	<div class="container border shadow-sm mt-5 p-5" style="width:60vh">
		<h4 class="mt-2 mb-5">상품 등록</h4>
		<form action="${ctx}/productInputOk.do" method="post" enctype="multipart/form-data">
			<table class="table table-borderless">
				<tbody>
					<tr>
						<td>카테고리</td>
						<td>
							<select class="form-select form-select-sm" name="pCategory_fk">
								<c:if test="${list == null || list.size() ==0}">
									<option value="">카테고리 없음</option>						
								</c:if>
								<c:if test="${list != null || list.size() !=0}">
									<c:forEach var="dto" items="${list}">
										<option value="${dto.code}">[${dto.name}]</option>
									</c:forEach>
								</c:if>		
							</select>
						</td>
					</tr>
					<tr>
						<td>상품명</td>
 						<td><input type="text" class="form-control form-control-sm" name="pName"/></td>
					</tr>
					<tr>
						<td>상품이미지</td>
						<td><input type="file" class="form-control form-control-sm" name="pImage"/></td>
					</tr>
					<tr>
						<td>상품가격</td>
						<td><input type="text" class="form-control form-control-sm" name="price"/></td>
					</tr>
					<tr>
						<td>상품수량</td>
						<td><input type="text" class="form-control form-control-sm" name="pQty"/></td>
					</tr>
					<tr>
						<td>상품사양</td>
						<td>
							<select class="form-select form-select-sm" name="pSpec">
								<option value="none" selected>일반</option>
								<c:forEach var="spec" items="${requestScope.pdSpecs}">
									<option value="${spec.name()}">${spec.value}</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<td>상품소개</td>
						<td>
							<textarea class="form-control" name="pContent" rows="3"></textarea>
						</td>
					</tr>
					<tr>
						<td>상품포인트</td>
						<td><input type="text" class="form-control form-control-sm" name="pPoint"/></td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<input type="submit" class="btn btn-dark" value="상품등록"/>	
							<input type="reset" class="btn btn-outline-success" value="취소"/>	
						</td>
					</tr>
				</tbody>			
			</table>	
		</form>
	</div> 
</main>
<%@ include file="/admin/inc/admin_bottom.jsp" %>