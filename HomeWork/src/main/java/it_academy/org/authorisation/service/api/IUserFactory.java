package it_academy.org.authorisation.service.api;

import it_academy.org.authorisation.dto.User;

public interface IUserFactory {
    User getUser(String login, String password, String firstName, String lastName, String thirdName, String birthday);
}
