<%@page import="java.util.Date"%>
<%@page import="vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%-- 지시자: header.jsp 포함 --%>
<%-- JSTL (JavaServer Pages Standard Tag Library) : 조건문 반복문, 포맷팅 등 태그형태로 자바 변수값 출력 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- fmt 시간설정사용 --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<%-- EL(Expression Language)을 사용한 값 출력 --%>
<p style="color: red">${name}</p>
<%-- xss (cross site scripting) : 공격자가 웹 페이지에 악성 스크립트를 삽입하여, 사용자의 브라우저에서 의도치 않은 행동을 하게 만드는 보안 취약점 --%>
<p>${script}</p>
<%-- 보안취약점으로인해 EL을 활용한 값 출력은 jstl을 사용하여 호출해야한다 --%>
<p><c:out value="${script}" /></p>
<%-- 객체 호출시 원하는 값만 가져올수있다 --%>
<p><c:out value="${stu1.name}" /></p>

<%-- if문 사용 계산 --%>
<c:if test="${not empty stu1 and stu1.id > 1000}">
  <p>트루</p>
</c:if>

<!-- 다중조건 if, else 사용-->
<c:choose>
	<c:when test="${name.equals('john')}">
	<p>j</p>
	</c:when>
	<c:when test="${name.equals('n')}">
	<p>n</p>
	</c:when>
	<c:when test=""></c:when>
	<c:when test=""></c:when>
</c:choose>

<!-- 루프 items: 변수명, var: 값을 담을 변수명 -->
<ul style="border: 1px solid red;">
  <c:forEach items="${student}" var="item">
    <li><c:out value="${item.name}" /></li>
  </c:forEach>
</ul>

<!-- 
eq : 같음 ${age == 20} = ${age eq 20}
ne : 같지 않음 ${age != 20} = ${age ne 20} 
lt : 작음 ${age < 20} = ${age lt 20}
le : 작거나 같음 ${age <= 20} = ${age le 20}
gt : 큼 ${age > 20} = ${age gt 20}
ge : 크거나 같음 ${age >= 20} = ${age ge 20}-->

<!-- fmt : 날짜 시간 숫자 문자열을 형식화 한다 -->
<%
Date currentDate = new Date();
pageContext.setAttribute("currentDate", currentDate);
pageContext.setAttribute("price", 10000);
%>

<fmt:formatDate value="${currentDate}" pattern="yyyy/MM/dd" /> '
<fmt:formatNumber value="${price}" pattern="###,###.00" />

<%-- 값 지정 --%>
<c:set var="product" value="프로덕트" />
<c:out value="${product}" />

<% for(String item : arr) { %>
    <p><%= item %></p>
<% } %>

<% for(StudentVO item : list) { %>
	<p>번호<%= i++ %>| 이름 : <%= item.getName() %> 아이디 : <%= item.getId() %> 등급 : <%= item.getGrade() %></p>
<% } %>
</main>

<%-- 지시자: footer.jsp 포함 --%>
<%@ include file="footer.jsp" %>
