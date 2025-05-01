<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<form method="post" action="login">
<div>
<input type="text" name="userId">
</div>
<div>
<input type="password" name="password">
</div>
<button type="submit">로그인</button>
</form>
<%@ include file="/inc/footer.jsp" %>