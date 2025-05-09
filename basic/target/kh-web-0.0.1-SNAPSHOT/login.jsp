<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<form method="post" action="/basic/loginAction">
	<div>
		<input type="text" name="userId" />
	</div>
	<div>
		<input type="password" name="password" />
	</div>
	<button type="submit">로그인</button>
</form>
</body>
</html>