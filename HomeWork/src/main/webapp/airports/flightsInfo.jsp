<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>


<head>
  <style type="text/css">
    TABLE {
        border-collapse: collapse; /* Убираем двойные линии между ячейками */
        font-size: 14px;
    }
    TD, TH {
        padding: 3px; /* Поля вокруг содержимого таблицы */
        border: 1px solid black; /* Параметры рамки */
    }
    .btn {
        display: inline-block; /* Строчно-блочный элемент */
        background: #8C959D; /* Серый цвет фона */
        color: #fff; /* Белый цвет текста */
        padding: 0.5rem 0.5rem;
        text-decoration: none; /* Убираем подчёркивание */
        border-radius: 3px; /* Скругляем уголки */
       }
  </style>
 </head>

<body>

    <%@include file="/airports/flights.jsp"%>

    <div>
        <c:if test="${flights != null}">
            <table>
                <thead>
                    <tr>
                        <th>flight id</th>
                        <th>flight no</th>
                        <th>scheduled departure</th>
                        <th>scheduled departure_local</th>
                        <th>scheduled arrival</th>
                        <th>scheduled arrival local</th>
                        <th>scheduled duration</th>
                        <th>departure airport</th>
                        <th>departure airport name</th>
                        <th>departure city</th>
                        <th>arrival airport</th>
                        <th>arrival airport name</th>
                        <th>arrival city</th>
                        <th>status</th>
                        <th>aircraft code</th>
                        <th>actual departure</th>
                        <th>actual departure local</th>
                        <th>actual arrival</th>
                        <th>actual arrival local</th>
                        <th>actual duration</th>
                    </tr>
                </thead>

                <tbody>
                    <c:forEach var="flight" items="${flights}">
                        <tr>
                            <c:out value="${flight.toTableString()}" escapeXml="false"/>
                        </tr>
                     </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>

    <div>
        <c:if test="${flights.size() == 25}">
              <p>
                <a href="${pageContext.request.contextPath}/flights?${filter.toParameterString()}&page=${page.page}" class="btn">Next</a>
              </p>
        </c:if>
    </div>
</body>