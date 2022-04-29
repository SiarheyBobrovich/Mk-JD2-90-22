package org.it_academy.airportsInfo.dto;

public class Airport {

    private String code;
    private String name;
    private String city;
    private String coordinates;
    private String timezone;


    public Airport(String code, String name, String sity, String coordinates, String timezone) {
        this.code = code;
        this.name = name;
        this.city = sity;
        this.coordinates = coordinates;
        this.timezone = timezone;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public String getTimezone() {
        return timezone;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", coordinates='" + coordinates + '\'' +
                ", timezone='" + timezone + '\'' +
                '}';
    }
}
