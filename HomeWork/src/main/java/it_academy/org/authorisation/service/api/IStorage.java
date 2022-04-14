package it_academy.org.authorisation.service.api;

import it_academy.org.authorisation.dto.User;

public interface IStorage {

    /**
     *Method searches in its base user by authenticator and return it
     * @param authenticator - User authenticator
     * @return User from storage
     */
    User get(String authenticator);

    /**
     * Checking if the base is located
     * @param authenticator - base param
     * @return - result of checking
     */
    boolean check(String authenticator, String password);

    /**
     * Save User in base
     * @param user - The user to save
     */
    void save(User user);
}
