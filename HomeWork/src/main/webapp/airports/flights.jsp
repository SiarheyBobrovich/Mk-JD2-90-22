<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="/includes/send.jsp"%><br>

<form action="${pageContext.request.contextPath}/flights?page=1&" method="GET">

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
                                <option value="${airport.code}"> ${airport.name} </option>
                            </c:forEach>
                        </select>
                    </td>
                    <td><input name ="departureDate" type="date"/></td>
                    <td>
                        <select name="arrivalAirport">
                            <option value="" selected></option>
                            <c:forEach var="airport" items="${airports}">
                               <option value="${airport.code}"> ${airport.name} </option>
                           </c:forEach>
                        </select>
                    </td>
                    <td><input name ="arrivalDate" type="date"/></td>
                </tr>
            </tbody>
    </table>
    <input type = "submit">
</form>
