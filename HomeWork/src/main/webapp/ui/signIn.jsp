<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/includes/main.jsp"%>

<h1>Sign in page</h1>

<%@include file="/includes/send.jsp"%>


<form action=<%= request.getContextPath() + "/api/login"%> method="POST">
 Enter:
        <p>Login:<input name ="login"</p><br>
        <p>Password:<input name ="password"</p><br>
        <p><input type = "submit"></p>
 </form>

