<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h3 class="mt-3">댓글목록</h3>

	<table class="table table-hover">
		<tbody>
			<c:forEach items="${list}" var="ar">
				<tr>
					<td>🌱${ar.boardWriter}</td>
					<td>${ar.createDate}</td>
					<td>${ar.boardContents}</td>
					<td>
						<c:if test="${ar.boardWriter eq member.member_id}">
							<button type="button" class="deletecommentbtn" data-comment-num="${ar.boardNum}">X</button>
							<button type="button" class="updatecommentbtn" data-comment-num="${ar.boardNum}">댓글수정</button>
						</c:if>
					</td>
				</tr>
			</c:forEach>
		</tbody>


	</table>



	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">

			<li class="page-item ${pager.pre?'':'disabled'}">
				<a class="page-link pn"
				href="#"
				aria-label="Previous" data-page-num="${pager.startNum-1}"> <span aria-hidden="true">&laquo;</span>
			</a></li>

			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1"
				var="i">
				<li class="page-item"><a class="page-link pn"
					href="#" data-page-num="${i}">${i}</a></li>
			</c:forEach>

			<li class="page-item ${pager.next?'':'disabled'}">
				<a class="page-link pn"
				href="#"
				aria-label="Next" data-page-num="${pager.lastNum+1}"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>
