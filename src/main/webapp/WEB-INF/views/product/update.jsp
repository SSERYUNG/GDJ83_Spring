<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/header_css.jsp"></c:import>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-image: url('/resources/images/background-img.png')">
<c:import url="/WEB-INF/views/sample/topheader.jsp"></c:import>


<div class = "justify-content-center text-center mt-3 mb-3">

<h3>상품 수정 정보 입력하기</h3>

</div>

<div class="container">
<form action="/product/update" method="post">
<input type="hidden" name = "item_id" value="${dto.item_id}">
<div>
<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">상품명</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name = "item_name" value="${dto.item_name}" >
</div>
<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">상품설명</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name = "item_detail" value="${dto.item_detail}">
</div>
<div class="mb-3">
  <label for="formGroupExampleInput" class="form-label">이자율</label>
  <input type="text" class="form-control" id="formGroupExampleInput" name ="item_rate" value="${dto.item_rate}">
</div>
</div>
<button type = "submit" class="btn btn-primary">수정하기</button>
</form>
</div>

<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
</body>
<script type="text/javascript" src="/resources/js/commons/files.js"></script>

<script>
    setMax(5);
    $("#productDetail").summernote();
</script>

</html>