package org.it_academy.messenger.service.api;

public interface IStatisticStorage {

    /**
     * increment count of messages
     */
    public void incrementCountMessages();

    /**
     * Method to get count of messages
     * @return - count of messages
     */
    public long getCountMessages();

    /**
     * increment count of active users
     */
    public void incrementCountUsers();

    /**
     * Method to get count of active users
     * @return count of users
     */
    public long getCountUsers();

    /**
     * decrement count of active users
     */
    public void decrementCountUsers();
}
