<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<style>
.b-header{
	border-bottom: 1px solid #ccc;
	padding: 1.5rem;
	background: #efefef;
}
.b-header p {
	font-size: 12px;
	margin: 10px 0 0 0;
}
.b-header p.dt {
	margin-left: 1rem;
	margin-right: 1rem;
}
.section {
	border-bottom: 1px solid #ccc;
	padding: 1.5rem;
}
.section p {
	margin: 0;
}
</style>
<article class="container mt-5 mb-5">
	<div class="b-header">
		<h2 class="h5">제목 : 제목 출력 영역</h2>
		<div class="d-flex justify-content-end">
			<p class="">작성자 : <span>누군가</span></p>
			<p class="dt">작성일 : <span>2025-01-1</span></p>
			<p class="">조회수 : <span>1</span></p>
		</div>
	</div>
	<div class="section mb-3">
		<p class="info">내용출력 영역!</p>
	</div>
	<div class="text-center">
		<a href="/board/list" class="btn btn-primary">확인</a>
		<a href="/board/write?id=1" class="btn btn-secondary">수정</a>
	</div>
</article>
<%@ include file="/inc/footer.jsp" %>