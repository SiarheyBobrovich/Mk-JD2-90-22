<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body>
    <%@include file="/includes/main.jsp"%>

    <p style="text-align:center; font-size:40">
        <strong>
            Sign up page
        </strong><br>
    </p>

    <div style="text-align:center; font-size:15px">
        <%@include file="/includes/send.jsp"%><br>
    </div>

    <div style="text-align:center">
        <span style="color:red"> * </span>required field<br>
    </div>

    <div style="text-align:center">
        <form action=<%= request.getContextPath() + "/api/user"%> method="POST">
            <p>Login <span style="color:red"> * </span>:        <input name ="login"></p><br>
            <p>Password <span style="color:red"> * </span>:     <input name ="password"></p><br>
            <p>FirstName <span style="color:red"> * </span>:    <input name ="firstName"></p><br>
            <p>LastName <span style="color:red"> * </span>:     <input name ="lastName"></p><br>
            <p>Third name:                                      <input name ="thirdName"></p><br>
            <p>Birthday <span style="color:red"> * </span>:     <input name ="birthday" type="date"></p><br>
            <p><input type = "submit"></p><br>
        </form>
    </div>
</body>