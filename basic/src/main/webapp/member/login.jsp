<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<style>
	@media (min-width: 576px) {
		.container {
			width: 300px;
		}
	}
</style>
<div class="container mt-5 mb-5">
	<form method="post" action="">
		<div class="mb-3">
		  <label for="userID" class="form-label">아이디</label>
		  <input type="text" class="form-control" id="userID" placeholder="아이디를 입력하세요.">
		</div>
		<div class="mb-3">
		  <label for="password" class="form-label">비밀번호</label>
		  <input type="password" class="form-control" id="password" placeholder="비밀번호를 입력하세요.">
		</div>
		<div class="d-grid gap-2">
			<button type="submit" class="btn btn-primary">로그인</button>
		</div>
		<div class="d-flex justify-content-between">
			<a href="/member/findAccount">아이디/비밀번호 찾기</a>
			<a href="/member/join">회원가입</a>
		</div>
	</form>
</div>



<div class="container">
  <div class="row align-items-start">
    <div class="col-sm-12 col-lg-6">
      sm : 모바일
      md : 태블릿
      lg : 데스크탑
      col-[사이즈]-숫자
    </div>
    <div class="col-sm-6 col-lg-3">
      One of three columns
    </div>
    <div class="col-sm-6 col-lg-3">
      One of three columns
    </div>
  </div>
</div>

<%@ include file="/inc/footer.jsp" %>