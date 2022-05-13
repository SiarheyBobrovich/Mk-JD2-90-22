package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public class Flights {
    private final Long flightId;
    private final String flightNo;
    private final OffsetDateTime scheduledDeparture;
    private final LocalDateTime scheduledDepartureLocal;
    private final OffsetDateTime scheduledArrival;
    private final LocalDateTime scheduledArrivalLocal;
    private final Duration scheduledDuration;
    private final String departureAirport;
    private final String departureAirportName;
    private final String departureCity;
    private final String arrivalAirport;
    private final String arrivalAirportName;
    private final String arrivalCity;
    private final String status;
    private final String aircraftCode;
    private final OffsetDateTime actualDeparture;
    private final LocalDateTime actualDepartureLocal;
    private final OffsetDateTime actualArrival;
    private final LocalDateTime actualArrivalLocal;
    private final Duration actualDuration;

    private Flights(Long flightId, String flightNo, OffsetDateTime scheduledDeparture,
                    LocalDateTime scheduledDepartureLocal, OffsetDateTime scheduledArrival,
                    LocalDateTime scheduledArrivalLocal, Duration scheduledDuration,
                    String departureAirport, String departureAirportName, String departureCity,
                    String arrivalAirport, String arrivalAirportName, String arrivalCity,
                    String status, String aircraftCode, OffsetDateTime actualDeparture,
                    LocalDateTime actualDepartureLocal, OffsetDateTime actualArrival,
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

    public OffsetDateTime getScheduledDeparture() {
        return scheduledDeparture;
    }

    public LocalDateTime getScheduledDepartureLocal() {
        return scheduledDepartureLocal;
    }

    public OffsetDateTime getScheduledArrival() {
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

    public OffsetDateTime getActualDeparture() {
        return actualDeparture;
    }

    public LocalDateTime getActualDepartureLocal() {
        return actualDepartureLocal;
    }

    public OffsetDateTime getActualArrival() {
        return actualArrival;
    }

    public LocalDateTime getActualArrivalLocal() {
        return actualArrivalLocal;
    }

    public Duration getActualDuration() {
        return actualDuration;
    }

    public static class Builder {
        private Long flightId;
        private String flightNo;
        private OffsetDateTime scheduledDeparture;
        private LocalDateTime scheduledDepartureLocal;
        private OffsetDateTime scheduledArrival;
        private LocalDateTime scheduledArrivalLocal;
        private Duration scheduledDuration;
        private String departureAirport;
        private String departureAirportName;
        private String departureCity;
        private String arrivalAirport;
        private String arrivalAirportName;
        private String arrivalCity;
        private String status;
        private String aircraftCode;
        private OffsetDateTime actualDeparture;
        private LocalDateTime actualDepartureLocal;
        private OffsetDateTime actualArrival;
        private LocalDateTime actualArrivalLocal;
        private Duration actualDuration;

        private Builder() {
        }

        public Builder setFlightId(Long flightId) {
            this.flightId = flightId;
            return this;
        }

        public Builder setFlightNo(String flightNo) {
            this.flightNo = flightNo;
            return this;
        }

        public Builder setScheduledDeparture(OffsetDateTime scheduledDeparture) {
            this.scheduledDeparture = scheduledDeparture;
            return this;
        }

        public Builder setScheduledDepartureLocal(LocalDateTime scheduledDepartureLocal) {
            this.scheduledDepartureLocal = scheduledDepartureLocal;
            return this;
        }

        public Builder setScheduledArrival(OffsetDateTime scheduledArrival) {
            this.scheduledArrival = scheduledArrival;
            return this;
        }

        public Builder setScheduledArrivalLocal(LocalDateTime scheduledArrivalLocal) {
            this.scheduledArrivalLocal = scheduledArrivalLocal;
            return this;
        }

        public Builder setScheduledDuration(Duration scheduledDuration) {
            this.scheduledDuration = scheduledDuration;
            return this;
        }

        public Builder setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder setDepartureAirportName(String departureAirportName) {
            this.departureAirportName = departureAirportName;
            return this;
        }

        public Builder setDepartureCity(String departureCity) {
            this.departureCity = departureCity;
            return this;
        }

        public Builder setArrivalAirport(String arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
            return this;
        }

        public Builder setArrivalAirportName(String arrivalAirportName) {
            this.arrivalAirportName = arrivalAirportName;
            return this;
        }

        public Builder setArrivalCity(String arrivalCity) {
            this.arrivalCity = arrivalCity;
            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder setAircraftCode(String aircraftCode) {
            this.aircraftCode = aircraftCode;
            return this;
        }

        public Builder setActualDeparture(OffsetDateTime actualDeparture) {
            this.actualDeparture = actualDeparture;
            return this;
        }

        public Builder setActualDepartureLocal(LocalDateTime actualDepartureLocal) {
            this.actualDepartureLocal = actualDepartureLocal;
            return this;
        }

        public Builder setActualArrival(OffsetDateTime actualArrival) {
            this.actualArrival = actualArrival;
            return this;
        }

        public Builder setActualArrivalLocal(LocalDateTime actualArrivalLocal) {
            this.actualArrivalLocal = actualArrivalLocal;
            return this;
        }

        public Builder setActualDuration(Duration actualDuration) {
            this.actualDuration = actualDuration;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public Flights build(){
            return new Flights(flightId, flightNo, scheduledDeparture, scheduledDepartureLocal, scheduledArrival,
                    scheduledArrivalLocal, scheduledDuration, departureAirport,
                    departureAirportName, departureCity, arrivalAirport, arrivalAirportName, arrivalCity, status,
                    aircraftCode, actualDeparture, actualDepartureLocal, actualArrival, actualArrivalLocal, actualDuration);
        }
    }
}
