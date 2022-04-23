<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<body>
    <div>
        <%@include file="/includes/main.jsp"%>
    </div>

    <p style="text-align:center; font-size:15px">
        <%@include file="/includes/send.jsp"%><br>
    </p>

	<p style="font-size: 30px; text-align: center">
		<strong>

		    <c:choose>
		        <c:when test="${user != null}">
		            Hello <c:out value="${user}"/>!
		        </c:when>
		        <c:otherwise>
		            Hello!
		        </c:otherwise>
		    </c:choose>
		</strong>
	</p>
</body>