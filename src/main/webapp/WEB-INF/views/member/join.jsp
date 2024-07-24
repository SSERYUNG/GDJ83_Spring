<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<div class ="container mt-5 justify-content-center">
  <form class="row g-3" action="/member/join" method="post" ID="frm" enctype="multipart/form-data">
  
    <div>
      <label for="inputID" class="form-label">ID</label>
      <input type="text" class="form-control" id="inputId" name="member_id">
      <div id="iderror"></div>
    </div>
    <div class="col-md-6">
      <label for="inputPassword" class="form-label">Password</label>
      <input type="password" class="form-control" id="inputPassword">
    </div>
    <div id="pwerror1"></div>
    <div class="col-md-6">
      <label for="inputPassword" class="form-label">passwordCheck</label>
      <input type="password" class="form-control" id="passwordCheck" name="member_pw">
    </div>
    <div id="pwerror2"></div>
    <div class="col-md-6">  
      <label for="inputName" class="form-label">Name</label>
      <input type="text" class="form-control" id="inputName" name="member_name">
    </div>
     <div class="col-md-6">
      <label for="inputPhone" class="form-label">Phone-Number</label>
      <input type="text" class="form-control" id="inputPhone" name="member_phone">
    </div>
    <div class="col-12">
      <label for="inputMail" class="form-label">E-mail</label>
      <input type="text" class="form-control" id="inputMail" name="member_mail">
    </div>
  
    <div class="col-12">
      <button type="button" class="btn btn-primary" id="add">사진파일추가</button>
    </div>
  
    <div id="result">
  
    </div>
  
    <div class="col-12">
      <button type="submit" class="btn btn-primary" id="btn">Join</button>
    </div>
    
  </form>
  
  </div>


<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
<script type="text/javascript" src="../resources/js/member/memberjoincheck.js"></script>
<script type="text/javascript" src="../resources/js/commons/files.js"></script>
</html>