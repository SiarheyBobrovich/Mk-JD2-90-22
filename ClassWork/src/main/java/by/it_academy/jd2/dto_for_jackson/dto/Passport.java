package by.it_academy.jd2.dto_for_jackson.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 	1. ИД гражданина
 * 	2. Кем выдан
 * 	3. Дата выдачи (LocalDate)
 * 	4. ИД паспорта
 */

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonDeserialize(builder = Passport.PassportBuilder.class)
public class Passport {

    private String id;
    private String idCitizen;
    private String address;

    @JsonSerialize(using = MyDateSerializer.class)

    private LocalDate createDate;

    public Passport(String id,
                    String idCitizen,
                    String address, LocalDate createDate) {
        this.id = id;
        this.idCitizen = idCitizen;
        this.address = address;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdCitizen() {
        return idCitizen;
    }

    public void setIdCitizen(String idCitizen) {
        this.idCitizen = idCitizen;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passport passport = (Passport) o;
        return Objects.equals(id, passport.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id='" + id + '\'' +
                ", idCitizen='" + idCitizen + '\'' +
                ", address='" + address + '\'' +
                ", createDate=" + createDate +
                '}';
    }
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    @JsonPOJOBuilder(buildMethodName = "create", withPrefix = "set")
    static class PassportBuilder {
        private String id;
        private String idCitizen;
        private String address;
        private LocalDate createDate;

        public PassportBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public PassportBuilder setIdCitizen(String idCitizen) {
            this.idCitizen = idCitizen;
            return this;
        }

        public PassportBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PassportBuilder setCreateDate(long createDate) {
            this.createDate = LocalDate.ofEpochDay(createDate);
            return this;
        }

        public Passport create() {
            return new Passport(id, idCitizen, address, createDate);
        }
    }
}
