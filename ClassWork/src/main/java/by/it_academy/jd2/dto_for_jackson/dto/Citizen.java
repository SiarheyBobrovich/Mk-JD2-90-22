package by.it_academy.jd2.dto_for_jackson.dto;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.time.LocalDate;
import java.util.Objects;

/**
 * 	1. ИД гражданина
 * 	2. Паспорт (объект типа Паспорт)
 * 	3. ФИО
 * 	4. Дата рождения (LocalDate)
 *
 * 	3. Эквивалентность гражданина определяется по ИД гражданина и паспорту
 */

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Citizen {

    private String id;
    private Passport passport;
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate birthday;

    public String getId() {
        return id;
    }

    @JsonSetter(value = "id")
    public void setId(String id) {
        this.id = id;
    }

    public Passport getPassport() {
        return passport;
    }

    public String getName() {
        return name;
    }

    @JsonSetter(value = "passport")
    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    @JsonSetter(value = "name")
    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    @JsonSetter(value = "birthday")
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        
        return Objects.equals(id, citizen.id) && Objects.equals(passport, citizen.passport);
    }
    
    public boolean isPassportOwner(Passport passport){
        return id.equals(passport.getIdCitizen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passport);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id='" + id + '\'' +
                ", passport=" + passport +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
