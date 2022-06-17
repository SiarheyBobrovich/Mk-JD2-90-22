package org.it_academy.messenger.service.api;

import java.util.List;

public interface IStorage<U, U1, M, M1> {

    /**
     *Method searches in its base user by authenticator and return it
     * @param authenticator - User authenticator
     * @return User from storage
     */
    U get(String authenticator);

    /**
     * Checking if the base is located
     * @param authenticator - base param
     * @return - result of checking
     */
    boolean check(String authenticator, String password);

    /**
     * Method to save S-object in memory
     * @param uDto - object to save
     */
    void save(U1 uDto);

    /**
     * Save sent messages
     * @param messageDto - The message will be added
     * @param loginTo - User's login who taken the message
     */
    void addMessage(M1 messageDto, String loginTo);

    /**
     * Method to get user's messages
     * @param u - Whose messages are requested
     * @return messages
     */
    List<M> getMessages(U u);
}
