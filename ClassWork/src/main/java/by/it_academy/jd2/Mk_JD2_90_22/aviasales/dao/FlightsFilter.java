package by.it_academy.jd2.Mk_JD2_90_22.aviasales.dao;

import java.time.LocalDateTime;

public class FlightsFilter {
    private final String departureAirport;
    private final String arrivalAirport;
    private final LocalDateTime scheduledDepartureLocal;
    private final LocalDateTime scheduledArrivalLocal;

    private FlightsFilter(String departureAirport, String arrivalAirport,
                         LocalDateTime scheduledDepartureLocal, LocalDateTime scheduledArrivalLocal) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.scheduledDepartureLocal = scheduledDepartureLocal;
        this.scheduledArrivalLocal = scheduledArrivalLocal;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalDateTime getScheduledDepartureLocal() {
        return scheduledDepartureLocal;
    }

    public LocalDateTime getScheduledArrivalLocal() {
        return scheduledArrivalLocal;
    }

    public static class Builder{
        private String departureAirport;
        private String arrivalAirport;
        private LocalDateTime scheduledDepartureLocal;
        private LocalDateTime scheduledArrivalLocal;

        private Builder() {
        }

        public Builder setDepartureAirport(String departureAirport) {
            this.departureAirport = departureAirport;
            return this;
        }

        public Builder setArrivalAirport(String arrivalAirport) {
            this.arrivalAirport = arrivalAirport;
            return this;
        }

        public Builder setScheduledDepartureLocal(LocalDateTime scheduledDepartureLocal) {
            this.scheduledDepartureLocal = scheduledDepartureLocal;
            return this;
        }

        public Builder setScheduledArrivalLocal(LocalDateTime scheduledArrivalLocal) {
            this.scheduledArrivalLocal = scheduledArrivalLocal;
            return this;
        }

        public static Builder create(){
            return new Builder();
        }

        public FlightsFilter build(){
            return new FlightsFilter(departureAirport,
                    arrivalAirport,
                    scheduledDepartureLocal,
                    scheduledArrivalLocal);
        }
    }
}
