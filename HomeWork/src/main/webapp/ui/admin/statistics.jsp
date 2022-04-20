<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<%@ include file="/includes/main.jsp"%><br>

<div style="text-align:center">
    <p>Count users: <c:out value="${countUsers}"/></p><br>
    Count messages: <c:out value="${sendMessages}"/><br>
</div>