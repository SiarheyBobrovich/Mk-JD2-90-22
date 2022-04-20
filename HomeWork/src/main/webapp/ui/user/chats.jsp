<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>


<%@include file="/includes/main.jsp"%>

<p style="text-align:center; font-size:30">
    <strong>Your message</strong><br>
</p>

<p>
    <c:choose>
        <c:when test="${messages.size() > 0}">
            Your messages:<br>
            <c:forEach var="message" items="${messages}">
                <li style="color:blue"><c:out value="${message}"/></li>
            </c:forEach>
        </c:when>
        <c:otherwise>
            You have no any messages, yet.
        </c:otherwise>
    </c:choose>
</p>
<ul>

</ul>