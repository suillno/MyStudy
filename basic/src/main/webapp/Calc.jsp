<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
<form method="post" action="/basic/calc">
	<div>
		<input type="number" name="num1">
	</div>
	<div>
		<input type="number" name="num2">
	</div>
	<div>
		<select name="oper">
		<option value="none">== 계산기호 ==</option>
		<option value="-">== 빼기 ==</option>
		<option value="+">== 더하기 ==</option>
		<option value="/">== 나누기 ==</option>
		<option value="*">== 곱하기 ==</option>
		</select>
	</div>
	<button type="submit">제출</button>
</form>
</body>
</html>