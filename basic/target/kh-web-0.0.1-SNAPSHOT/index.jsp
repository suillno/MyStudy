<%@page import="java.util.Date"%>
<%@page import="vo.StudentVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>
<main>

<p style="color: red">${name}</p>
<p><c:out value="${script}" /></p>
<p><c:out value="${student.name}" /></p>
<!-- 단일 조건 -->
<c:if test="${student.id > 0}">
<p>트루</p>
</c:if>
<!-- 다중 조건 -->
<c:choose>
	<c:when test="${name.equals('j')}">
		<p>J</p>
	</c:when>
	<c:when test="${name.equals('John')}">
		<p>john</p>
	</c:when>
	<c:otherwise></c:otherwise>
</c:choose>

<ul style="border: 1px solid red;">

<c:forEach items="${list}" var="item">
<li><c:out value="${item.name}" /></li>
</c:forEach>

</ul>

<!-- 
eq : 같음 ${age == 20} ${age eq 20} ${name eq '이름'}
ne : 같지 않음 ${age != 20} ${age ne 20}
lt : 작음 ${age < 20} ${age lt 20}
le : 작거나 같음 ${age <= 20} ${age le 20}
gt : 큼 ${age > 20} ${age gt 20}
ge : 크거나 같음 ${age >= 20} ${age ge 20}
 -->

fmt : 날짜, 시간, 숫자, 문자열을 형식화한다.

<%
Date currentDate = new Date();
pageContext.setAttribute("currentDate", currentDate);
pageContext.setAttribute("price", 10000000);
%>
<c:set var="product" value="프로덕트" />
<c:out value="${product}" />

<fmt:formatDate value="${currentDate}" pattern="yyyy-MM-dd"  />
<fmt:formatNumber value="${price}" pattern="###,###.00" />


<ul>
<%

	List<StudentVO> list = (List<StudentVO>) request.getAttribute("list");

	for (StudentVO item : list) {
%>
	<li>번호: <%=item.getId() %>
	, 이름 : <%=item.getName() %>
	, 등급 : <%=item.getGrade() %></li>
<%
}
%>
</ul>
</main>
<%@ include file="footer.jsp" %>