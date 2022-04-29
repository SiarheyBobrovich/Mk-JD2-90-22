package org.it_academy.messenger.service;

import org.it_academy.messenger.core.dto.Message;
import org.it_academy.messenger.core.dto.User;
import org.it_academy.messenger.service.api.IUserFactory;
import org.it_academy.messenger.core.dto.enums.Role;
import org.it_academy.messenger.service.api.IUserStorage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserStorage implements IUserStorage<User> {

    private static final IUserStorage<User> storage = new UserStorage();
    private final Map<String, User> userContainer;
    private final Map<User, List<Message>> messageMap;

    private UserStorage() {
        this.userContainer = new HashMap<>();
        this.messageMap = new HashMap<>();

        addAdmin();
    }

    private void addAdmin() {
        save("admin", "admin",
                "admin", "admin", "admin",
                "1987-06-27"
        );
        this.userContainer.get("admin").setStatus(Role.ADMIN);
    }

    public static IUserStorage<User> getInstance() {
        return storage;
    }

    @Override
    public User get(String authenticator) {
        return userContainer.get(authenticator.toLowerCase());
    }

    @Override
    public boolean check(String authenticator, String password) {
        User user = userContainer.get(authenticator.toLowerCase());

        if (user == null || !user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid login/password!");
        }

        return true;
    }

    @Override
    public void save(String login, String password, String firstName, String lastName, String thirdName, String birthday) {
        login = login.toLowerCase();

        if (userContainer.containsKey(login)){
            throw new IllegalArgumentException("This login's already exist!");
        }

        IUserFactory<User> factory = new UserFactory();
        User user = factory.createUser(login, password, firstName, lastName, thirdName, birthday);

        synchronized (userContainer) {
            this.userContainer.put(user.getLogin(), user);
        }

        synchronized (this.messageMap) {
            this.messageMap.put(user, new ArrayList<>());
        }
    }

    @Override
    public synchronized void addMessage(String loginFrom, String loginTo, String text) {
        loginFrom = loginFrom.toLowerCase();
        loginTo = loginTo.toLowerCase();

        User userFrom = this.userContainer.get(loginFrom);
        User userTo = this.userContainer.get(loginTo);
        this.messageMap.get(userTo)
                .add(new Message(userFrom, userTo, text))
        ;
    }

    @Override
    public List<Message> getMessages(String login) {
        login = login.toLowerCase();

        User user = this.userContainer.get(login);
        return this.messageMap.get(user);
    }
}
