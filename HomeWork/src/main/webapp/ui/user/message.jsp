<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/includes/main.jsp"%>
<h1>Send message</h1>
<form action=<%= request.getContextPath() + "/api/message"%> method="POST">

        <p>Login:  <input name ="toUser"</p><br>
        <p>Text:   <input name ="text"</p><br>

 <p><input type = "submit"></p>
