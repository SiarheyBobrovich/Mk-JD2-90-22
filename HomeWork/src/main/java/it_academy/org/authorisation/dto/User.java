package it_academy.org.authorisation.dto;

import it_academy.org.authorisation.dto.enums.Role;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {

    private final List<Message> messageList = new ArrayList<>();
    private final String login;
    private String password;
    private String firstName;
    private String lastName;
    private String thirdName;
    private final LocalDate birthday;
    private final LocalDateTime authorisationDate;
    private Role status;


    public User(String login, String password, String firstName, String lastName, LocalDate birthday) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.status = Role.USER;
        this.authorisationDate = LocalDateTime.now();
    }

    public synchronized void addMessage(Message message) {
        this.messageList.add(message);
    }

    public List<Message> getMessageList() {
        return List.copyOf(messageList);
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
        return lastName + " " + firstName + " " +
                (thirdName != null ? thirdName : "");
    }
}
