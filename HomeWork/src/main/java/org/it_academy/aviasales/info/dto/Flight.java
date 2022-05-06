package org.it_academy.aviasales.info.dto;

import org.it_academy.aviasales.info.dto.api.BaseAirportObject;

import java.time.Duration;
import java.time.LocalDateTime;

public class Flight implements BaseAirportObject {

    private final Long flightId;
    private final String flightNo;
    private final LocalDateTime scheduledDeparture;
    private final LocalDateTime scheduledDepartureLocal;
    private final LocalDateTime scheduledArrival;
    private final LocalDateTime scheduledArrivalLocal;
    private final Duration scheduledDuration;
    private final String departureAirport;
    private final String departureAirportName;
    private final String departureCity;
    private final String arrivalAirport;
    private final String arrivalAirportName;
    private final String arrivalCity;
    private final String  status;
    private final String aircraftCode;
    private final LocalDateTime actualDeparture;
    private final LocalDateTime actualDepartureLocal;
    private final LocalDateTime actualArrival;
    private final LocalDateTime actualArrivalLocal;
    private final Duration actualDuration;

    public Flight(Long flightId, String flightNo, LocalDateTime scheduledDeparture, LocalDateTime scheduledDepartureLocal,
                  LocalDateTime scheduledArrival, LocalDateTime scheduledArrivalLocal, Duration scheduledDuration,
                  String departureAirport, String departureAirportName, String departureCity, String arrivalAirport,
                  String arrivalAirportName, String arrivalCity, String status, String aircraftCode,
                  LocalDateTime actualDeparture, LocalDateTime actualDepartureLocal, LocalDateTime actualArrival,
                  LocalDateTime actualArrivalLocal, Duration actualDuration) {
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

    public Long getFlightId() {
        return flightId;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public LocalDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public LocalDateTime getScheduledDepartureLocal() {
        return scheduledDepartureLocal;
    }

    public LocalDateTime getScheduledArrival() {
        return scheduledArrival;
    }

    public LocalDateTime getScheduledArrivalLocal() {
        return scheduledArrivalLocal;
    }

    public Duration getScheduledDuration() {
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

    public LocalDateTime getActualDeparture() {
        return actualDeparture;
    }

    public LocalDateTime getActualDepartureLocal() {
        return actualDepartureLocal;
    }

    public LocalDateTime getActualArrival() {
        return actualArrival;
    }

    public LocalDateTime getActualArrivalLocal() {
        return actualArrivalLocal;
    }

    public Duration getActualDuration() {
        return actualDuration;
    }

    @Override
    public String toTableString() {
        String startTableTag = "<td>";
        String endTableTag = "</td>";

        return  startTableTag + (flightId != null ? flightId : "") + endTableTag +
                startTableTag + (flightNo != null ? flightNo : "") + endTableTag +
                startTableTag + (scheduledDeparture != null ? scheduledDeparture.toString() : "") + endTableTag +
                startTableTag + (scheduledDepartureLocal != null ? scheduledDepartureLocal.toString() : "") + endTableTag +
                startTableTag + (scheduledArrival != null ? scheduledArrival.toString() : "") + endTableTag +
                startTableTag + (scheduledArrivalLocal != null ? scheduledArrivalLocal.toString() : "") + endTableTag +
                startTableTag + (scheduledDuration != null ? scheduledDuration.toString() : "") + endTableTag +
                startTableTag + (departureAirport != null ? departureAirport : "") + endTableTag +
                startTableTag + (departureAirportName != null ? departureAirportName : "") + endTableTag +
                startTableTag + (departureCity != null ? departureCity : "") + endTableTag +
                startTableTag + (arrivalAirport != null ? arrivalAirport : "") + endTableTag +
                startTableTag + (arrivalAirportName != null ? arrivalAirportName : "") + endTableTag +
                startTableTag + (arrivalCity != null ? arrivalCity : "") + endTableTag +
                startTableTag + (status != null ? status : "") + endTableTag +
                startTableTag + (aircraftCode != null ? aircraftCode : "") + endTableTag +
                startTableTag + (actualDeparture != null ? actualDeparture.toString() : "") + endTableTag +
                startTableTag + (actualDepartureLocal != null ? actualDepartureLocal.toString() : "") + endTableTag +
                startTableTag + (actualArrival != null ? actualArrival.toString() : "") + endTableTag +
                startTableTag + (actualArrivalLocal != null ? actualArrivalLocal.toString() : "") + endTableTag +
                startTableTag + (actualDuration != null ? actualDuration.toString() : "") + endTableTag;
    }

    public static class Builder {

        private Long flightId;
        private String flightNo;
        private LocalDateTime scheduledDeparture;
        private LocalDateTime scheduledDepartureLocal;
        private LocalDateTime scheduledArrival;
        private LocalDateTime scheduledArrivalLocal;
        private Duration scheduledDuration;
        private String departureAirport;
        private String departureAirportName;
        private String departureCity;
        private String arrivalAirport;
        private String arrivalAirportName;
        private String arrivalCity;
        private String  status;
        private String aircraftCode;
        private LocalDateTime actualDeparture;
        private LocalDateTime actualDepartureLocal;
        private LocalDateTime actualArrival;
        private LocalDateTime actualArrivalLocal;
        private Duration actualDuration;

        private Builder() {}

        public void setFlightId(Long flightId) {
            this.flightId = flightId;
        }

        public void setFlightNo(String flightNo) {
            this.flightNo = flightNo;
        }

        public void setScheduledDeparture(LocalDateTime scheduledDeparture) {
            this.scheduledDeparture = scheduledDeparture;
        }

        public void setScheduledDepartureLocal(LocalDateTime scheduledDepartureLocal) {
            this.scheduledDepartureLocal = scheduledDepartureLocal;
        }

        public void setScheduledArrival(LocalDateTime scheduledArrival) {
            this.scheduledArrival = scheduledArrival;
        }

        public void setScheduledArrivalLocal(LocalDateTime scheduledArrivalLocal) {
            this.scheduledArrivalLocal = scheduledArrivalLocal;
        }

        public void setScheduledDuration(Duration scheduledDuration) {
            this.scheduledDuration = scheduledDuration;
        }

        public void setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
        }

        public void setDepartureAirportName(String departureAirportName) {
            this.departureAirportName = departureAirportName;
        }

        public void setDepartureCity(String departureCity) {
            this.departureCity = departureCity;
        }

        public void setArrivalAirport(String arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
        }

        public void setArrivalAirportName(String arrivalAirportName) {
            this.arrivalAirportName = arrivalAirportName;
        }

        public void setArrivalCity(String arrivalCity) {
            this.arrivalCity = arrivalCity;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setAircraftCode(String aircraftCode) {
            this.aircraftCode = aircraftCode;
        }

        public void setActualDeparture(LocalDateTime actualDeparture) {
            this.actualDeparture = actualDeparture;
        }

        public void setActualDepartureLocal(LocalDateTime actualDepartureLocal) {
            this.actualDepartureLocal = actualDepartureLocal;
        }

        public void setActualArrival(LocalDateTime actualArrival) {
            this.actualArrival = actualArrival;
        }

        public void setActualArrivalLocal(LocalDateTime actualArrivalLocal) {
            this.actualArrivalLocal = actualArrivalLocal;
        }

        public void setActualDuration(Duration actualDuration) {
            this.actualDuration = actualDuration;
        }

        public static Builder create() {
            return new Builder();
        }

        public Flight build() {
            return new Flight(
                    flightId,
                    flightNo,
                    scheduledDeparture,
                    scheduledDepartureLocal,
                    scheduledArrival,
                    scheduledArrivalLocal,
                    scheduledDuration,
                    departureAirport,
                    departureAirportName,
                    departureCity,
                    arrivalAirport,
                    arrivalAirportName,
                    arrivalCity,
                    status,
                    aircraftCode,
                    actualDeparture,
                    actualDepartureLocal,
                    actualArrival,
                    actualArrivalLocal,
                    actualDuration
            );
        }
    }
}
