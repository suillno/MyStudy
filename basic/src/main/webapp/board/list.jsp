<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<style>
<!-- 휴대폰화면시 표기화면 조정 -->
.phone p {
	margin: 0;
}
</style>
<div class="container">
<table class="table">
	<!-- 테이블 크기 조정및 화면크기에따른 감추기효과 적용 -->
	<colgroup>
		<col style="width:50px" />
		<col style="width:70px"/>
		<col />
		<col class="d-none d-md-table-cell" style="width:100px"/>
		<col class="d-none d-md-table-cell" style="width:100px"/>
		<col class="d-none d-md-table-cell" style="width:70px"/>
	</colgroup>
  <thead>
    <tr>
      <th scope="col">선택</th>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th class="d-none d-md-table-cell" scope="col">작성자</th>
      <th class="d-none d-md-table-cell" scope="col">작성일</th>
      <th class="d-none d-md-table-cell" scope="col">조회수</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">
      	<input type="checkbox" />
      </th>
      <th scope="row">1</th>
      <td>
      <a href="/board/view?id=1">ejfo fiejg; oejfkgj</a>
      <!-- 화면이 줄어들었을때 표기 -->
      	<div class="d-table-cell d-md-none phone">
      		<p>작성자명</p>
      		<p>2025-01-01</p>
      		<p>1</p>
      	</div>
      </td>
      <td class="d-none d-md-table-cell">Otto</td>
      <td class="d-none d-md-table-cell">@mdo</td>
      <td class="d-none d-md-table-cell">1</td>
    </tr>
  </tbody>
</table>
<%-- 글쓰기 버튼 --%>
<div class="text-end">
	<a href="/board/write" class="btn btn-outline-success">글쓰기</a>
</div>
<%-- 페이지 번호 --%>
<div">
	<nav aria-label="Page navigation example">
  <ul class="pagination justify-content-center">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li class="page-item"><a class="page-link" href="#">1</a></li>
    <li class="page-item"><a class="page-link" href="#">2</a></li>
    <li class="page-item"><a class="page-link" href="#">3</a></li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>
</div>

<%@ include file="/inc/footer.jsp" %>