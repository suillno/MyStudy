<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<style>
textarea {
	min-height: 300px;
}
</style>
<div class="container mt-5 mb-5">
<form method="post" action="/board/write" onsubmit="return checkForm();">
	<input type="hidden" name="id" value="<c:out value="${result.boardNo}" />" />
	<div class="mb-3">
	  <label for="title" class="form-label">제목</label>
	  <input type="text" name="boardTitle" class="form-control" 
	  	id="title" placeholder="제목을 입력하세요." 
	  	value="<c:out value="${result.boardTitle}" />" />
	</div>
	<div class="mb-3">
	  <div class="form-floating">
		  <textarea class="form-control" name="boardContent" 
		  	placeholder="내용작성" id="content"><c:out value="${result.boardContent}" /></textarea>
		  <label for="content">내용</label>
		</div>
	</div>
	<div class="text-center">
		<button type="submit" id="btnSave" class="btn btn-primary">저장</button>
		<a href="/board/list" class="btn btn-dark">취소</a>
	</div>
</form>
</div>

<script>
function checkForm() {
	console.log('폼 제출');
	// 제목
	const title = document.querySelector('input[name=boardTitle]').value;
	// 내용
	const content = document.querySelector('textarea[name=boardContent]').value;
	console.log(title, content);
	if (title && content) {
		return true;
	}
	return false;
}
</script>

<%@ include file="/inc/footer.jsp" %>