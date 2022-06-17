package org.it_academy.messenger.core.dto;

public class UserDto {
    private final String login;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String thirdName;
    private final String birthday;

    public UserDto(String login, String password,
                   String firstName, String lastName,
                   String thirdName, String birthday) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.thirdName = thirdName;
        this.birthday = birthday;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public String getBirthday() {
        return birthday;
    }

    public static Builder create() {
        return new Builder();
    }

    public static class Builder {

        private String login;
        private String password;
        private String firstName;
        private String lastName;
        private String thirdName;
        private String birthday;

        public Builder setLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setThirdName(String thirdName) {
            this.thirdName = thirdName;
            return this;
        }

        public Builder setBirthday(String birthday) {
            this.birthday = birthday;
            return this;
        }

        public UserDto build() {
            return new UserDto(
                    login, password, firstName,
                    lastName, thirdName, birthday
            );
        }
    }
}
