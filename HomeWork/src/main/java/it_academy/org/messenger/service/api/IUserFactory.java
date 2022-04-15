package it_academy.org.messenger.service.api;

import it_academy.org.messenger.core.dto.User;

public interface IUserFactory<U extends User> {
    U createUser(String login, String password, String firstName, String lastName, String thirdName, String birthday);
}
