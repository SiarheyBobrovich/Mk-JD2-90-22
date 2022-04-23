<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/includes/main.jsp"%>

<p style="text-align:center; font-size:40px">
    <strong>
        Send message page
    </strong><br>
</p>

<div style="text-align:center; font-size:15px">
    <%@include file="/includes/send.jsp"%>
</div>

<div style="text-align:center">
    <form action=<%= request.getContextPath() + "/api/message"%> method="POST">
            <p>Login:  <input name ="toUser"</p><br>
            <p>Text:   <input name ="text"</p><br>
    <p><input type = "submit"></p>
<div style="text-align:center">

