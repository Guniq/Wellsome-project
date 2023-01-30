<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<%@ include file="/customer/inc/user_top.jsp" %>
<main>
	<div class="container mt-5 mb-5">
	<h4 class="text-center">공지사항</h4>
		<hr class="container" style="width:15vh; border:1px solid #1a5c3e;">
		<table class="table mt-5 mb-5" style="width:100%;">
			<tbody>
				<c:forEach var="dto" items="${dtos}">
						<tr>
							<td class="text-center" style="width:10vh">${dto.bNum}</td>
							<td class="text-center"><a href="${ctx}/userBoardInfo.do?bNum=${dto.bNum}" style="color:black; text-decoration:none">${dto.bTitle}</a></td>
							<td style="width:30vh">${dto.bName}</td>
							<td style="width:30vh">${dto.bDate}</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</main>
<%@ include file="/customer/inc/user_bottom.jsp" %>