<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<body>
    <form action=<%= request.getContextPath() + "/flight?offset=0"%> method="POST">

        <table>
            <thead>
                <tr>
                    <th>departureAirport</th>
                    <th>departureDate</th>
                    <th>arrivalAirport</th>
                    <th>arrivalDate</th>
                </tr>
            </thead>

                <tbody>
                    <tr>
                        <td>
                            <select name="departureAirport">
                                <option value="" selected></option>
                                <c:forEach var="airport" items="${airports}">
                                    <option value="${airport.getName()}"> ${airport.getName()} </option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><input name ="departureDate" type="date"/></td>
                        <td>
                            <select name="arrivalAirport">
                                <option value="" selected></option>
                                <c:forEach var="airport" items="${airports}">
                                   <option value="${airport.getName()}"> ${airport.getName()} </option>
                               </c:forEach>
                            </select>
                        </td>
                        <td><input name ="arrivalDate" type="date"/></td>
                    </tr>
                </tbody>
        </table>
        <input type = "submit">
    </form>
</body>