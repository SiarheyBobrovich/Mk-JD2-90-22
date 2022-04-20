package it_academy.org.messenger.service.api;

import it_academy.org.messenger.core.dto.Message;
import it_academy.org.messenger.core.dto.User;

import java.util.List;

public interface IUserStorage<T extends User> {

    /**
     *Method searches in its base user by authenticator and return it
     * @param authenticator - User authenticator
     * @return User from storage
     */
    T get(String authenticator);

    /**
     * Checking if the base is located
     * @param authenticator - base param
     * @return - result of checking
     */
    boolean check(String authenticator, String password);

    /**
     *
     * @param login - param "login" from user
     * @param password - param "password" from user
     * @param firstName - param "name" from user
     * @param lastName - param "surname" from user
     * @param thirdName - param "patronymic" from user
     * @param birthday - date(dd.MM.yyyy) from user
     */
    void save(String login, String password, String firstName, String lastName, String thirdName, String birthday);

    /**
     * Save sent messages
     * @param loginFrom - User's login who has sent the message
     * @param loginTo - User's login who taken the message
     * @param text - Message's text
     */
    void addMessage(String loginFrom, String loginTo, String text);

    /**
     * Method to get user's messages
     * @param login - Whose messages are requested
     * @return messages
     */
    List<Message> getMessages(String login);
}
