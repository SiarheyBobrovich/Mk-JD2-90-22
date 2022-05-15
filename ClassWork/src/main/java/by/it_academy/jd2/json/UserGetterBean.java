package by.it_academy.jd2.json;

import com.fasterxml.jackson.annotation.JsonGetter;

public class UserGetterBean {
    private int id; //Нет геттера -> нет сериализации
    private String firstName;

    public UserGetterBean(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }

    @JsonGetter(value = "name")
    public String getFirstName() {
        return firstName;
    }

    @JsonGetter(value = "family")
    public String getLastName() {
        return "Jackson";
    }
}
