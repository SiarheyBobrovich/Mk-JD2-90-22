<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h1>Генерация рандомных чисел</h1>

<%!
    private double random = Math.random();
    private double random1 = Math.random();
    private double random2 = Math.random();
%>

<%=
    this.random + " " +
    this.random1
%>

<p>
    <% random2 = Math.random(); %>

    <%= random2 %>
</p>