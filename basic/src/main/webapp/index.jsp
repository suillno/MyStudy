<%@page import="vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 지시자: header.jsp 포함 --%>
<%@ include file="header.jsp" %>

<main>
<% 
    // 스크립트릿: 자바 코드 작성
    String name = "임꺽정";
    String[] arr = {"a","b","c","d","e"};
    // 값가져오기
    List<StudentVO> list = (List<StudentVO>) request.getAttribute("student");
    int i = 1;
%>

<p><%= name %></p> <%-- 익스프레션: name 값 출력 --%>

<% for(String item : arr) { %>
    <p><%= item %></p>
<% } %>

<% for(StudentVO item : list) { %>
	<p>번호<%= i++ %>| 이름 : <%= item.getName() %> 아이디 : <%= item.getId() %> 등급 : <%= item.getGrade() %></p>
<% } %>
</main>

<%-- 지시자: footer.jsp 포함 --%>
<%@ include file="footer.jsp" %>
