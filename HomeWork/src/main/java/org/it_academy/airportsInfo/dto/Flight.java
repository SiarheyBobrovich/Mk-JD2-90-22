package org.it_academy.airportsInfo.dto;

public class Flight {

    private final String flight_id;
    private final String flight_no;
    private final String scheduled_departure;
    private final String scheduled_departure_local;
    private final String scheduled_arrival;
    private final String scheduled_arrival_local;
    private final String scheduled_duration;
    private final String departure_airport;
    private final String departure_airport_name;
    private final String departure_city;
    private final String arrival_airport;
    private final String arrival_airport_name;
    private final String arrival_city, status;
    private final String aircraft_code;
    private final String actual_departure;
    private final String actual_departure_local;
    private final String actual_arrival;
    private final String actual_arrival_local;
    private final String actual_duration;

    public Flight(String flight_id,
                  String flight_no,
                  String scheduled_departure,
                  String scheduled_departure_local,
                  String scheduled_arrival,
                  String scheduled_arrival_local,
                  String scheduled_duration,
                  String departure_airport,
                  String departure_airport_name,
                  String departure_city,
                  String arrival_airport,
                  String arrival_airport_name,
                  String arrival_city,
                  String status,
                  String aircraft_code,
                  String actual_departure,
                  String actual_departure_local,
                  String actual_arrival,
                  String actual_arrival_local,
                  String actual_duration
    ) {
        this.flight_id = flight_id;
        this.flight_no = flight_no;
        this.scheduled_departure = scheduled_departure;
        this.scheduled_departure_local = scheduled_departure_local;
        this.scheduled_arrival = scheduled_arrival;
        this.scheduled_arrival_local = scheduled_arrival_local;
        this.scheduled_duration = scheduled_duration;
        this.departure_airport = departure_airport;
        this.departure_airport_name = departure_airport_name;
        this.departure_city = departure_city;
        this.arrival_airport = arrival_airport;
        this.arrival_airport_name = arrival_airport_name;
        this.arrival_city = arrival_city;
        this.status = status;
        this.aircraft_code = aircraft_code;
        this.actual_departure = actual_departure;
        this.actual_departure_local = actual_departure_local;
        this.actual_arrival = actual_arrival;
        this.actual_arrival_local = actual_arrival_local;
        this.actual_duration = actual_duration;
    }

    public String getFlight_id() {
        return flight_id;
    }

    public String getFlight_no() {
        return flight_no;
    }

    public String getScheduled_departure() {
        return scheduled_departure;
    }

    public String getScheduled_departure_local() {
        return scheduled_departure_local;
    }

    public String getScheduled_arrival() {
        return scheduled_arrival;
    }

    public String getScheduled_arrival_local() {
        return scheduled_arrival_local;
    }

    public String getScheduled_duration() {
        return scheduled_duration;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public String getDeparture_airport_name() {
        return departure_airport_name;
    }

    public String getDeparture_city() {
        return departure_city;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public String getArrival_airport_name() {
        return arrival_airport_name;
    }

    public String getArrival_city() {
        return arrival_city;
    }

    public String getStatus() {
        return status;
    }

    public String getAircraft_code() {
        return aircraft_code;
    }

    public String getActual_departure() {
        return actual_departure;
    }

    public String getActual_departure_local() {
        return actual_departure_local;
    }

    public String getActual_arrival() {
        return actual_arrival;
    }

    public String getActual_arrival_local() {
        return actual_arrival_local;
    }

    public String getActual_duration() {
        return actual_duration;
    }
}
