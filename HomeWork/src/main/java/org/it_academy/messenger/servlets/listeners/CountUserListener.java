package org.it_academy.messenger.servlets.listeners;

import org.it_academy.messenger.service.StatisticStorage;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
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
