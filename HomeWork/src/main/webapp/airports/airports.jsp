<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<div>
    <table>
        <thead>
            <tr>
                <th>code</th>
                <th>name</th>
                <th>city</th>
                <th>coordinates</th>
                <th>timezone</th>
            <tr>
        </thead>
        <tbody>
            <c:forEach var="airport" items="${airports}">
                <tr>
                    <c:out value="${airport.getTableString()}" escapeXml="false"/>
                </tr>
             </c:forEach>
        </tbody>
    </table>
</div>