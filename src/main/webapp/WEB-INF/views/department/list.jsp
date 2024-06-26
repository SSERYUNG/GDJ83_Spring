<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

	<h1>부서 리스트</h1>
	
	<div>
	<table class="table table-bordered border-primary text-center">
		<thead>
			<tr class="table-info">
				<th>부서번호</th>
				<th>부서명</th>
				<th>관리자</th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${list}" var="dto">
				<tr>
					<td>${dto.department_id}</td>
					<td><a href="/department/detail?department_id=${dto.department_id}">${dto.department_name}</a></td>
					<td>${dto.manager_id}</td>
				</tr>		
			</c:forEach>
		
		
		</tbody>
	
	
	
	</table>
	
		<div>
		
			<a class="btn btn-info" href="./add" role="button">부서등록</a>
		
		</div>
	
	
	</div>
	

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</body>
</html>