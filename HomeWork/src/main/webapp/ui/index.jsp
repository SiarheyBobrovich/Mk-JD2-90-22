<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/includes/main.jsp"%>

<%! private String signInPath; %>
<% signInPath = request.getContextPath() + "/ui/signIn"; %>

    <body>
        <p><a href=<%= request.getContextPath() + "/ui/signIn"%>> SignIn </a></p>
        <p><a href=<%= request.getContextPath() + "/ui/signUp"%>> SignUp </a></p>
        <p><a href=<%= request.getContextPath() + "/ui/user/chats"%>> Chat </a></p>
        <p><a href=<%= request.getContextPath() + "/ui/user/message.jsp"%>> Send message </a></p>

    </body>
</html>