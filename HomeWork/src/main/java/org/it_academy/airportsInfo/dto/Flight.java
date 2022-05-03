package org.it_academy.airportsInfo.dto;

import org.it_academy.airportsInfo.dto.api.BaseAirportObject;

public class Flight implements BaseAirportObject {

    private final String flightId;
    private final String flightNo;
    private final String scheduledDeparture;
    private final String scheduledDepartureLocal;
    private final String scheduledArrival;
    private final String scheduledArrivalLocal;
    private final String scheduledDuration;
    private final String departureAirport;
    private final String departureAirportName;
    private final String departureCity;
    private final String arrivalAirport;
    private final String arrivalAirportName;
    private final String arrivalCity;
    private final String  status;
    private final String aircraftCode;
    private final String actualDeparture;
    private final String actualDepartureLocal;
    private final String actualArrival;
    private final String actualArrivalLocal;
    private final String actualDuration;

    public Flight(String flightId,
                  String flightNo,
                  String scheduledDeparture,
                  String scheduledDepartureLocal,
                  String scheduledArrival,
                  String scheduledArrivalLocal,
                  String scheduledDuration,
                  String departureAirport,
                  String departureAirportName,
                  String departureCity,
                  String arrivalAirport,
                  String arrivalAirportName,
                  String arrivalCity,
                  String status,
                  String aircraftCode,
                  String actualDeparture,
                  String actualDepartureLocal,
                  String actualArrival,
                  String actualArrivalLocal,
                  String actualDuration
    ) {
        this.flightId = flightId;
        this.flightNo = flightNo;
        this.scheduledDeparture = scheduledDeparture;
        this.scheduledDepartureLocal = scheduledDepartureLocal;
        this.scheduledArrival = scheduledArrival;
        this.scheduledArrivalLocal = scheduledArrivalLocal;
        this.scheduledDuration = scheduledDuration;
        this.departureAirport = departureAirport;
        this.departureAirportName = departureAirportName;
        this.departureCity = departureCity;
        this.arrivalAirport = arrivalAirport;
        this.arrivalAirportName = arrivalAirportName;
        this.arrivalCity = arrivalCity;
        this.status = status;
        this.aircraftCode = aircraftCode;
        this.actualDeparture = actualDeparture;
        this.actualDepartureLocal = actualDepartureLocal;
        this.actualArrival = actualArrival;
        this.actualArrivalLocal = actualArrivalLocal;
        this.actualDuration = actualDuration;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public String getScheduledDeparture() {
        return scheduledDeparture;
    }

    public String getScheduledDepartureLocal() {
        return scheduledDepartureLocal;
    }

    public String getScheduledArrival() {
        return scheduledArrival;
    }

    public String getScheduledArrivalLocal() {
        return scheduledArrivalLocal;
    }

    public String getScheduledDuration() {
        return scheduledDuration;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getDepartureAirportName() {
        return departureAirportName;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public String getArrivalAirportName() {
        return arrivalAirportName;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public String getStatus() {
        return status;
    }

    public String getAircraftCode() {
        return aircraftCode;
    }

    public String getActualDeparture() {
        return actualDeparture;
    }

    public String getActualDepartureLocal() {
        return actualDepartureLocal;
    }

    public String getActualArrival() {
        return actualArrival;
    }

    public String getActualArrivalLocal() {
        return actualArrivalLocal;
    }

    public String getActualDuration() {
        return actualDuration;
    }

    @Override
    public String getTableString() {
        String startTableTag = "<td>";
        String endTableTag = "</td>";

        return  startTableTag + (flightId != null ? flightId : "") + endTableTag +
                startTableTag + (flightNo != null ? flightNo : "") + endTableTag +
                startTableTag + (scheduledDeparture != null ? scheduledDeparture : "") + endTableTag +
                startTableTag + (scheduledDepartureLocal != null ? scheduledDepartureLocal : "") + endTableTag +
                startTableTag + (scheduledArrival != null ? scheduledArrival : "") + endTableTag +
                startTableTag + (scheduledArrivalLocal != null ? scheduledArrivalLocal : "") + endTableTag +
                startTableTag + (scheduledDuration != null ? scheduledDuration : "") + endTableTag +
                startTableTag + (departureAirport != null ? departureAirport : "") + endTableTag +
                startTableTag + (departureAirportName != null ? departureAirportName : "") + endTableTag +
                startTableTag + (departureCity != null ? departureCity : "") + endTableTag +
                startTableTag + (arrivalAirport != null ? arrivalAirport : "") + endTableTag +
                startTableTag + (arrivalAirportName != null ? arrivalAirportName : "") + endTableTag +
                startTableTag + (arrivalCity != null ? arrivalCity : "") + endTableTag +
                startTableTag + (status != null ? status : "") + endTableTag +
                startTableTag + (aircraftCode != null ? aircraftCode : "") + endTableTag +
                startTableTag + (actualDeparture != null ? actualDeparture : "") + endTableTag +
                startTableTag + (actualDepartureLocal != null ? actualDepartureLocal : "") + endTableTag +
                startTableTag + (actualArrival != null ? actualArrival : "") + endTableTag +
                startTableTag + (actualArrivalLocal != null ? actualArrivalLocal : "") + endTableTag +
                startTableTag + (actualDuration != null ? actualDuration : "") + endTableTag;
    }
}
