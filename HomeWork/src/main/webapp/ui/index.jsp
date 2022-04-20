<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="it_academy.org.messenger.core.dto.User"
%>

<%@include file="/includes/main.jsp"%>

<body>
	<p style="font-size: 30px; text-align: center">
		<strong>
		    Welcome ${sessionScope.user != null ? sessionScope.user : ""}!
		</strong>
	</p>
</body>