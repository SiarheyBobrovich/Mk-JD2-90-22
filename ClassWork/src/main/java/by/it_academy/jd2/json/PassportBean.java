package by.it_academy.jd2.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class PassportBean {

    private String id;

    private String personId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    @JsonCreator
    public PassportBean(@JsonProperty("string") String id,
                        @JsonProperty("personId") String personId,
                        @JsonProperty(value = "createDate", defaultValue = "null") LocalDate createDate) {
        this.id = id;
        this.personId = personId;
        this.createDate = createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }


    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "PassportBean{" +
                "id='" + id + '\'' +
                ", personId='" + personId + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
