package it_academy.org.messenger.servlets.listeners;

import it_academy.org.messenger.service.StatisticStorage;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class CountUserListener implements HttpSessionAttributeListener {

    private static final StatisticStorage storage = StatisticStorage.getInstance();

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        Object user = event.getSession().getAttribute("user");
        if (user != null) {
            storage.incrementCountUsers();
        }
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        storage.decrementCountUsers();
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {

    }
}
