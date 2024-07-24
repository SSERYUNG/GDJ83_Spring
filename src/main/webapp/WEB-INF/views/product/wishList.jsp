<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/header_css.jsp"></c:import>
</head>
<body style="background-image: url('/resources/images/background-img.png')">

	<c:import url="/WEB-INF/views/sample/topheader.jsp"></c:import>
</body>


<div class = "justify-content-center text-center mt-3 mb-3">

<h3>위시리스트</h3>

</div>

<div class="container mt-5 justify-content-center text-center">

	<div align="left">
		<button type="button" class="btn btn-primary mb-3" id="checkdelete">선택삭제</button>
	</div>


	<table class="table table-hover">

		<thead>

			<tr>
				<td>
				<input type="checkbox" id="allbox">
				</td>
				<td>상품명</td>
				<td>이자율</td>
				<td>삭제</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="ar" varStatus="i">
				<tr id="w{i.index}">
					<td><input type="checkbox" class="wishcheck" data-check-delete="${ar.item_id}" data-wish-delete="w{i.index}"></td>
					<td>${ar.item_name}</td>
					<td>${ar.item_rate}</td>
					<td><button type="button" class="btn btn-primary wishDelete" data-wish-delete="${ar.item_id}">X</button></td>
				</tr>
			</c:forEach>
		</tbody>


	</table>
</div>

<%-- <div class="container justify-content-center text-center mb-5">

	<div style="float: right">
		<a href="/product/add"><button class="btn btn-primary">상품
				추가</button></a>
	</div>

</div>

<!--페이지 버튼-->

<div class="container justify-content-center text-center">
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">

			<li class="page-item ${pager.pre?'':'disabled'}"><a
				class="page-link"
				href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}"
				aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>

			<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" step="1"
				var="i">
				<li class="page-item"><a class="page-link"
					href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
			</c:forEach>

			<li class="page-item ${pager.next?'':'disabled'}"><a
				class="page-link"
				href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}"
				aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</nav>

	<form action="./list" method="get"
		class="row row-cols-lg-auto g-3 align-items-center justify-content-end">


		<div class="col-12">
			<label class="visually-hidden" for="inlineFormSelectPref">Preference</label>
			<select name="kind" class="form-select" id="inlineFormSelectPref">
				<option value="k1">상품명</option>
				<option value="k2">상품내용</option>
			</select>
		</div>

		<div class="col-12">
			<label class="visually-hidden" for="inlineFormInputGroupUsername"></label>
			<div class="input-group">
				<input name="search" type="text" class="form-control"
					id="inlineFormInputGroupUsername" placeholder="검색어를 입력하세요">
			</div>
		</div>
		<div class="col-12">
			<button type="submit" class="btn btn-primary">검색하기</button>
		</div>
	</form>
</div> --%>
<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
<script src="/resources/js/product/wishDelete.js"></script>
</html>