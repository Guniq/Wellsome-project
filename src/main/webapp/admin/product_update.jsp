<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="/admin/inc/admin_top.jsp" %>
<main>
	<div class="container border shadow-sm mt-5 p-5" style="width:60vh">
		<h4 class="mt-2 mb-5">상품 수정</h4>
		<form action="${ctx}/productUpdateOk.do" method="post" enctype="multipart/form-data">
		<input type="hidden" name="pNum" value="${pDto.pNum}"/>
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
								<c:forEach var="cDto" items="${list}">
									<c:if test="${cDto.code == pDto.pCategory_fk}">
										<option value="${cDto.code}" selected>[${cDto.name}]</option>
									</c:if>
									<c:if test="${cDto.code != pDto.pCategory_fk}">
										<option value="${cDto.code}">[${cDto.name}]</option>
									</c:if>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" class="form-control form-control-sm" name="pName" value="${pDto.pName}"/></td>
				</tr>
				<tr>
					<td>상품이미지</td>
					<td>
						<img src="${ctx}/uploadedFile/${pDto.pImage}" width="100px"/>
						<input type="file" class="form-control form-control-sm" 
						name="pImage"/>
						<!-- 이미지를 수정하지 않고 그대로 사용할 경우 -->
						<input type="hidden" class="form-control form-control-sm" 
						name="pImageOld" value="${pDto.pImage}"/>
					</td>
				</tr>
				<tr>
					<td>상품수량</td>
					<td><input type="text" class="form-control form-control-sm" 
					name="pQty" value="${pDto.pQty}"/></td>
				</tr>
				<tr>
					<td>상품가격</td>
					<td><input type="text" class="form-control form-control-sm" 
					name="price" value="${pDto.price}"/></td>
				</tr>
				<tr>
					<td>상품사양</td>
					<td>
						<select class="form-select form-select-sm" name="pSpec">
							<c:forEach var="spec" items="${requestScope.pdSpecs}">
								<c:if test="${spec.name() == pDto.pSpec}">
									<option value="${spec.name()}">${spec.value}</option>
								</c:if>
							</c:forEach>
							<c:forEach var="spec" items="${requestScope.pdSpecs}">
								<c:if test="${spec.name() != pDto.pSpec}">
									<option value="none">일반</option>
								</c:if>
									<option value="${spec.name()}">${spec.value}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>상품소개</td>
					<td>
						<textarea class="form-control" name="pContent" rows="3">${pDto.pContent}</textarea>
					</td>
				</tr>
				<tr>
					<td>상품포인트</td>
					<td><input type="text" class="form-control form-control-sm" 
					name="pPoint" value="${pDto.pPoint}"/></td>
				</tr>
				<tr>
					<td colspan="2" class="text-center pt-4">
						<input type="submit" class="btn btn-sm btn-dark" value="상품수정"/>	
						<input type="reset" class="btn btn-sm btn-outline-success" value="취소"/>	
					</td>
				</tr>
			</tbody>			
		</table>
		</form>	
	</div>
</main>

<%@ include file="/admin/inc/admin_bottom.jsp" %>