package by.it_academy.jd2.json;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPropertyBean {
    private int id;

    @JsonProperty(value = "name")
    private String firstName;


    public UserPropertyBean(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    @JsonProperty(value = "first-name") //Создаёт ещё одно поле в JSON
    public String getFirstName() {
        return firstName;
    }
}
