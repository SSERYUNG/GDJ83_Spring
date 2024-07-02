<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

<div class ="container mt-5 justify-content-center text-center">

<table class="table table-hover">

	<thead>
	
		<tr>
			<td>상품번호</td>
			<td>상품명</td>
			<td>상품설명</td>
			<td>이자율</td>
		</tr>
	</thead>
	<tbody>
			<c:forEach items="${requestScope.list}" var="ar">
		<tr>
		
			<td>${ar.item_id}</td>
			<td><a href="./detail?item_id=${ar.item_id}">${ar.item_name}</a></td>
			<td>${ar.item_detail}</td>
			<td>${ar.item_rate}</td>
		
		</tr>	
			</c:forEach>
	</tbody>


</table>

</div>




<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>