<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기</title>
</head>
<body>
<% 
	// 포워딩된 값 가져오기
	int result = (int) request.getAttribute("result");
%>
<h2>계산 결과는 <%= result %> 입니다</h2>
</body>
</html>