package by.it_academy.jd2.json;

import com.fasterxml.jackson.annotation.JsonValue;

public class UserValueBean extends UserPropertyBean{
    private int id;
    private String firstName;

    public UserValueBean(int id, String firstName) {
        super(id, firstName);
        this.id = id;
        this.firstName = firstName;
    }


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    @JsonValue
    @Override
    public String toString() {
        return "UserValueBean{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
