<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<body>
    <%@include file="/includes/main.jsp"%>

    <div style="text-align:center; font-size:40px">
        <strong>
            Your message page
        </strong><br>
    </div>

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
</body>
