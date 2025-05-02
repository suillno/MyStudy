<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<style>
textarea {
	min-height: 300px;
}
</style>
<div class="container mt-5 mb-5">
<form method="post">
	<div class="mb-3">
	  <label for="title" class="form-label">제목</label>
	  <input type="text" class="form-control" id="title" placeholder="제목을 입력하세요.">
	</div>
	<div class="mb-3">
	  <div class="form-floating">
		  <textarea class="form-control" placeholder="내용작성" id="content"></textarea>
		  <label for="content">내용</label>
		</div>
	</div>
	<div class="text-center">
		<button type="button" class="btn btn-primary">저장</button>
		<a href="/board/list" class="btn btn-dark">취소</a>
	</div>
</form>
</div>
<%@ include file="/inc/footer.jsp" %>