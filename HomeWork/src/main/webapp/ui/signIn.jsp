<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/includes/main.jsp"%>

<p style="text-align:center; font-size:30">
    <strong>Sign in page</strong><br>
</p>

<div style="text-align:center; font-size:15px">
    <%@include file="/includes/send.jsp"%>
</div>

<div style="text-align:center">
    <form action=<%= request.getContextPath() + "/api/login"%> method="POST">
        Login:<input name ="login"><br>
        Password:<input name ="password"><br>
        <input type = "submit">
    </form>
</div>
