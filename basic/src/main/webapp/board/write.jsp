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
	<div class="mb-3">
	  <label for="title" class="form-label">제목</label>
	  <input type="text" class="form-control" name="boardTitle" id="title" placeholder="제목을 입력하세요.">
	</div>
	<div class="mb-3">
	  <div class="form-floating">
		  <textarea class="form-control" name="boardContent" placeholder="내용작성" id="content"></textarea>
		  <label for="content">내용</label>
		</div>
	</div>
	<div class="text-center">
		<button type="submit" id="btnSave" class="btn btn-primary">저장</button>
		<a href="/board/list" class="btn btn-dark">취소</a>
	</div>
</form>
</div>
<!-- 저장버튼 클릭시 동작 -->
<script>
function checkForm() {
	// 제목
	const title = document.querySelector('input[name=boardTitle]').value;
	// 내용
	const content = document.querySelector('textarea[name=boardContent]').value;
	if (title && content) {
		return true;
	}
	return false;
}

</script>
<%@ include file="/inc/footer.jsp" %>