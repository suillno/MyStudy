<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<style>
.show-sub-info {
	display: none;
}
.show-sub-info p {
	margin: 0;
	font-size: 12px;
}
@media (max-width: 767px) {
	.hide-cell {
		display: none;
	}
	.show-sub-info {
		display: block;
	}
}
</style>
<form method="post" action="/board/delete" onsubmit="return onDelete()" class="container">
<table class="table">
	<colgroup>
		<col style="width:100px" />
		<col style="width:70px" />
		<col />
		<col class="hide-cell" style="width:100px" />
		<col class="hide-cell" style="width:100px" />
		<col class="hide-cell" style="width:70px" />
	</colgroup>
  <thead>
    <tr>
      <th scope="col"><input type="checkbox" onclick="toggleAll(this)" />전체선택</th>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th class="hide-cell" scope="col">작성자</th>
      <th class="hide-cell" scope="col">작성일</th>
      <th class="hide-cell" scope="col">조회수</th>
    </tr>
  </thead>
  <tbody>
  	<c:forEach items="${list}" var="item">
	    <tr>
	      <th scope="row">
	      	<input type="checkbox" name="nos" value="<c:out value="${item.boardNo}" />" />
	      </th>
	      <th><c:out value="${item.boardNo}" /></th>
	      <td>
	      	<a href="/board/view?id=<c:out value="${item.boardNo}" />"><c:out value="${item.boardTitle}" /></a>
	      	<div class="show-sub-info">
	      		<p><c:out value="${item.boardWriter}" /></p>
	      		<p><c:out value="${item.regDate}" /></p>
	      		<p>1</p>
	      	</div>
	      </td>
	      <td class="hide-cell"><c:out value="${item.boardWriter}" /></td>
	      <td class="hide-cell"><c:out value="${item.regDate}" /></td>
	      <td class="hide-cell">1</td>
	    </tr>
    </c:forEach>
  </tbody>
</table>
<div class="d-flex justify-content-between">
	<button type="submit" class="btn btn-danger">삭제</button>
	<a href="/board/write" class="btn btn-primary">글쓰기</a>
</div>
<div class="d-flex justify-content-center">
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
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
</form>
<style>
.searchForm {
	width: 300px;
	margin: 0 auto;
}
.searchForm button {
	width: 150px;
}
</style>
<form method="get" action="/board/list" class="d-flex searchForm">
	<select class="form-select" name="searchType">
		<option value="title">제목</option>
		<option value="content">내용</option>
	</select>
	<input type="text" class="form-control" name="searchKeyword" />
	<button type="button" class="btn btn-secondary">검색</button>
</form>



<script>
function toggleAll(_target) {
	const nosList = document.querySelectorAll('input[name=nos]');
	for(let i = 0; i < nosList.length; i++) {
		nosList[i].checked = _target.checked;
	}
}
function onDelete() {
	const nosList = document.querySelectorAll('input[name=nos]:checked');
	if (nosList.length > 0 && confirm('삭제하시겠습니까?')) return true;
	return false;
}
</script>



<%@ include file="/inc/footer.jsp" %>