package by.it_academy.jd2.json;

public class Airport {
                                        //  {
    private final String code;          //      "code" : "1023",
    private final String name;          //      "name " : "HAB",
    private final String city;          //      "city" : "Хабаровск",
    private final String coordinates;   //      "coordinates" : "6.66,9.99",
    private final String timezone;      //      "timezone" : "Europe/Minsk"
                                        //  }


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
