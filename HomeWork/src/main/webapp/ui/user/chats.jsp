<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>


<%@include file="/includes/main.jsp"%>

<%@include file="/includes/send.jsp"%>

    <h1>
        <c:choose>
            <c:when test="${messages.size() > 0}">
                Your messages
            </c:when>
        </c:choose>
    </h1>
    <ul>
        <c:forEach var="message" items="${messages}">
            <li><c:out value="${message}" /></li>
        </c:forEach>
    </ul>

    <%@include file="/ui/user/message.jsp"%>
