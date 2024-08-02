<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/header_css.jsp"></c:import>
<style>
	.ck.ck-editor{
	   max-width: 1000px;
  }
  .ck-editor__editable {
     min-height: 400px;
     max-height: 600px;
  }
  .ck-content { 
	  font-size: 12px; 
	 }
</style>
</head>
<body style="background-image: url('/resources/images/background-img.png')">

<c:import url="/WEB-INF/views/sample/topheader.jsp"></c:import>
</body>

<c:choose>
	<c:when test="${write=='add'}">
	
		<div class = "justify-content-center text-center mt-3 mb-3">
			<c:choose>
				<c:when test="${reply=='reply'}">
					<h3>${board} 답글 작성하기</h3>
				</c:when>
				<c:otherwise>
					<h3>${board} 새 글 작성하기</h3>
				</c:otherwise>
			</c:choose>
		</div>
		
			<div class="container text-left">
				<form method ="post" enctype="multipart/form-data">
				<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label disabled">작성자</label>
				  <input class="form-control" type="text" name="boardWriter" value="${member.member_id}" readonly aria-label="input example">
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">글제목</label>
				  <input type="text" class="form-control" id="exampleFormControlInput1" name="boardTitle">
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
				  <textarea class="form-control" id="editor" rows="6" name="boardContents"></textarea>
				</div>
				
				  <div class="col-12">
		    		<button type="button" class="btn btn-primary" id="add">파일추가</button>
		  		 </div>
		
				  <div id="result">			
				  </div>
				  
				  <div class="col-8 mt-3">
				  <button type="submit" class="btn btn-primary">작성하기</button>
				  </div>
				</form>
			</div>
	</c:when>


	<c:otherwise>
		<div class = "justify-content-center text-center mt-3 mb-3">
		<h3>글 수정하기</h3>
		</div>
		
		<div class="container">
			<form method="post">
			<input type="hidden" name="boardNum" value="${dto.boardNum}">
				<div class="mb-3">
				  <label for="exampleFormControlInput1" class="form-label">글제목</label>
				  <input type="text" class="form-control" id="exampleFormControlInput1" name="boardTitle" value="${dto.boardTitle}">
				</div>
				<div class="mb-3">
				  <label for="exampleFormControlTextarea1" class="form-label">글내용</label>
				  <textarea class="form-control" id="editor" rows="6" name="boardContents">${dto.boardContents}</textarea>
				</div>
				<div class="col-8 mt-3">
				  <button type="submit" class="btn btn-primary">수정하기</button>
				  </div>	
			</form>	
		</div>
	</c:otherwise>
</c:choose>



<c:import url="/WEB-INF/views/sample/footer.jsp"></c:import>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
<script type="text/javascript" src="/resources/js/commons/ckeditor.js"></script>
<script type="text/javascript" src="/resources/js/commons/files.js"></script>
<script>
   setMax(5)
    
	ClassicEditor.create( 
		document.getElementById( 'editor' ), {
			extraPlugins: [MyCustomUploadAdapterPlugin]
       },
	   
     )
	 .then(editor=>{
		window.editor=editor
	 })
	 
	 .catch(error=>{
			console.log('error')
	 });	
    
</script>

</html>