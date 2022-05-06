package org.it_academy.aviasales.info.dto;

import org.it_academy.aviasales.info.dto.api.BaseAirportObject;

public class Airport implements BaseAirportObject {

    private final String code;
    private final String name;
    private final String city;
    private final String coordinates;
    private final String timezone;


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
    public String toTableString() {
        String startTableTag = "<td>";
        String endTableTag = "</td>";

        return startTableTag + code + endTableTag +
                startTableTag + name + endTableTag +
                startTableTag + city + endTableTag +
                startTableTag + coordinates + endTableTag +
                startTableTag + timezone + endTableTag;
    }

    public static class Builder {
        private String code;
        private String name;
        private String city;
        private String coordinates;
        private String timezone;

        private Builder() {}

        public void setCode(String code) {
            this.code = code;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setCoordinates(String coordinates) {
            this.coordinates = coordinates;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        public Airport build() {
            return new Airport(
                    code,
                    name,
                    city,
                    coordinates,
                    timezone
            );
        }

        public static Builder create() {
            return new Builder();
        }
    }
}
