<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="/basic/calcAction">
		<div>
			<input type="number" name="num1" />
		</div>
		<div>
			<input type="number" name="num2" />
		</div>
		<div>
			<select name="operator">
				<option value="">선택하세요.</option>
				<option value="+">+</option>
				<option value="-">-</option>
				<option value="*">*</option>
				<option value="/">/</option>
			</select>
		</div>
		<button type="submit">제출</button>
	</form>
</body>
</html>