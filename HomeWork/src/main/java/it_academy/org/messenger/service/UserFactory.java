package it_academy.org.messenger.service;

import it_academy.org.messenger.core.dto.User;
import it_academy.org.messenger.core.dto.enums.Role;
import it_academy.org.messenger.service.api.IUserFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserFactory implements IUserFactory<User> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private boolean isInvalid = false;
    private String errorMessage = "Invalid:";

    @Override
    public User createUser(String login, String password, String firstName, String lastName, String thirdName, String userBirthday) {
        checkParameter(login, "login");
        checkParameter(password, "password");
        checkParameter(firstName, "firstName");
        checkParameter(lastName, "lastName");
        LocalDate birthday = getBirthday(userBirthday);

        if (isInvalid) {
            throw new IllegalArgumentException(this.errorMessage);
        }

        User user = new User(login, password, firstName, lastName, birthday);
        user.setStatus(Role.USER);

        if (thirdName != null && thirdName.length() != 0) {
            user.setThirdName(thirdName);
        }

        return user;
    }

    private void checkParameter(String str, String param) {
        if (str == null || str.length() == 0) {
            this.errorMessage += (!this.isInvalid ? " " : ", ") + param;
            this.isInvalid = true;
        }
    }

    private LocalDate getBirthday(String str) {
        if (str != null) {
            LocalDate date;

            try {
                date = LocalDate.parse(str, formatter);
                return date;

            }catch (DateTimeParseException e) {
                this.errorMessage +=
                        (!this.isInvalid ? " " : ", ") +
                        "birthday";
                this.isInvalid = true;
                return null;
            }
        }

        this.errorMessage += (!this.isInvalid ? " " : ", ") + "birthday";
        this.isInvalid = true;

        return null;
    }
}
