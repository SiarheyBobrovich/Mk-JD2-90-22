package org.it_academy.messenger.dao.entity;

import org.it_academy.messenger.core.dto.enums.Role;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class User implements Serializable {

    private final String login;
    private String password;
    private String firstName;
    private String lastName;
    private String thirdName;
    private final LocalDate birthday;
    private final LocalDateTime authorisationDate;
    private Role status;

    public User(String login, String password,
                String firstName, String lastName,
                LocalDate birthday) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.authorisationDate = LocalDateTime.now();
        this.status = Role.USER;
    }

    public String getLogin() {
        return login;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDateTime getAuthorisationDate() {
        return authorisationDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public Role getStatus() {
        return status;
    }

    public void setStatus(Role status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName +
                (thirdName != null ? (" " + thirdName) : "");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return login.equalsIgnoreCase(user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login);
    }
}
