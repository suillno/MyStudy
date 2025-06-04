<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int result = (int) request.getAttribute("result");
	String resultStr = String.valueOf(request.getAttribute("result"));
%>
<h2>계산 결과는 <%= result %> 입니다.</h2>
</body>
</html>




