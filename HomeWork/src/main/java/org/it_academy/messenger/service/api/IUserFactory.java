package org.it_academy.messenger.service.api;

import org.it_academy.messenger.core.dto.User;

public interface IUserFactory<U extends User> {
    U createUser(String login, String password, String firstName, String lastName, String thirdName, String birthday);
}
