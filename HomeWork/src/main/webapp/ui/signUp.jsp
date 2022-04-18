<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/includes/main.jsp"%>

<h1>Sign up page</h1>

<%@include file="/includes/send.jsp"%>

<form action=<%= request.getContextPath() + "/api/user"%> method="POST">
 Enter: * required field
        <p>Login*:       <input name ="login"</p><br>
        <p>Password*:    <input name ="password"</p><br>
        <p>Surname*:     <input name ="lastName"</p><br>
        <p>Name*:        <input name ="firstName"</p><br>
        <p>Third name:  <input name ="thirdName"</p><br>
        <p>Birthday*:    <input name ="birthday" placeholder="example: 24.08.1991"> </p><br>

 <p><input type = "submit"></p>
 </form>