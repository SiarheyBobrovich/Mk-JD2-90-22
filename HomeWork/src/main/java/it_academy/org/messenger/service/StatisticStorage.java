package it_academy.org.messenger.service;

import it_academy.org.messenger.service.api.IStatisticStorage;

public class StatisticStorage implements IStatisticStorage {

    private static final StatisticStorage storage = new StatisticStorage();

    private long countUsers;
    private long countMessages;


    private StatisticStorage() {

    }


    public static StatisticStorage getInstance() {
        return storage;
    }

    @Override
    public synchronized void incrementCountMessages() {
        countMessages++;
    }

    @Override
    public long getCountMessages() {
        return countMessages;
    }

    @Override
    public long getCountUsers() {
        return countUsers;
    }

    @Override
    public synchronized void incrementCountUsers() {
        countUsers++;
    }

    @Override
    public synchronized void decrementCountUsers() {
        countUsers--;
    }
}
