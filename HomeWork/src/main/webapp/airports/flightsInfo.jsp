<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>

<table>
        <thead>
            <tr>
                <th>flight_id</th>
                <th>flight_no</th>
                <th>scheduled_departure</th>
                <th>scheduled_departure_local</th>
                <th>scheduled_arrival</th>
                <th>scheduled_arrival_local</th>
                <th>scheduled_duration</th>
                <th>departure_airport</th>
                <th>departure_airport_name</th>
                <th>departure_city</th>
                <th>arrival_airport</th>
                <th>arrival_airport_name</th>
                <th>arrival_city</th>
                <th>status</th>
                <th>aircraft_code</th>
                <th>actual_departure</th>
                <th>actual_departure_local</th>
                <th>actual_arrival</th>
                <th>actual_arrival_local</th>
                <th>actual_duration</th>
            </tr>
        </thead>



        <tbody>

            <c:forEach var="flight" items="${flights}">
                <tr>
                    <td><c:out value="${flight.getFlight_id()}"/></td>
                    <td><c:out value="${flight.getFlight_no()}"/></td>
                    <td><c:out value="${flight.getScheduled_departure()}"/></td>
                    <td><c:out value="${flight.getScheduled_departure_local()}"/></td>
                    <td><c:out value="${flight.getScheduled_arrival()}"/></td>
                    <td><c:out value="${flight.getScheduled_arrival_local()}"/></td>
                    <td><c:out value="${flight.getScheduled_duration()}"/></td>
                    <td><c:out value="${flight.getDeparture_airport()}"/></td>
                    <td><c:out value="${flight.getDeparture_airport_name()}"/></td>
                    <td><c:out value="${flight.getDeparture_city()}"/></td>
                    <td><c:out value="${flight.getArrival_airport()}"/></td>
                    <td><c:out value="${flight.getArrival_airport_name()}"/></td>
                    <td><c:out value="${flight.getArrival_city()}"/></td>
                    <td><c:out value="${flight.getAircraft_code()}"/></td>
                    <td><c:out value="${flight.getActual_departure()}"/></td>
                    <td><c:out value="${flight.getActual_departure_local()}"/></td>
                    <td><c:out value="${flight.getActual_arrival()}"/></td>
                    <td><c:out value="${flight.getActual_arrival_local()}"/></td>
                    <td><c:out value="${flight.getActual_duration()}"/></td>
                </tr>
             </c:forEach>
        </tbody>
    </table>