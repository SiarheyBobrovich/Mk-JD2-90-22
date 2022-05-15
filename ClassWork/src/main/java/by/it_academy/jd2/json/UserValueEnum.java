package by.it_academy.jd2.json;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserValueEnum {
    FIRST_NAME("Siarhey"),
    LAST_NAME("Bobrovich");

    private String name;
    UserValueEnum(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
