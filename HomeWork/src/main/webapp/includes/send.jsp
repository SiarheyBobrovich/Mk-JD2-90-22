<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3 style="color:red">
    ${param.error!=null?param.error:""}
</h3>

<h3 style="color:green">
    ${param.message!=null?param.message:""}
</h3>
