package it_academy.org.messenger.service;

import it_academy.org.messenger.core.dto.Message;
import it_academy.org.messenger.core.dto.User;
import it_academy.org.messenger.service.api.IUserFactory;
import it_academy.org.messenger.core.dto.enums.Role;
import it_academy.org.messenger.service.api.IUserStorage;

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

        save("admin", "admin",
                "admin", "admin", "admin",
                "27.06.1987"

        );

        this.userContainer.get("admin").setStatus(Role.ADMIN);

    }

    public static IUserStorage<User> getInstance() {
        return storage;
    }

    @Override
    public User get(String authenticator) {
        return userContainer.get(authenticator);
    }

    @Override
    public boolean check(String authenticator, String password) {

        if (!userContainer.containsKey(authenticator)) {
            throw new IllegalArgumentException("Invalid login");
        }

        User user = userContainer.get(authenticator);

        if (!user.getPassword().equalsIgnoreCase(password)) {
            throw new IllegalArgumentException("Invalid password");
        }

        return true;
    }

    @Override
    public void save(String login, String password, String firstName, String lastName, String thirdName, String birthday) {
        IUserFactory<User> factory = new UserFactory();
        User user = factory.createUser(login, password, firstName, lastName, thirdName, birthday);

        synchronized (userContainer) {

            if (userContainer.containsKey(login)){
                throw new IllegalArgumentException("This login's already exist");
            }
            this.userContainer.put(user.getLogin(), user);
        }

        synchronized (this.messageMap) {
            this.messageMap.put(user, new ArrayList<>());
        }


    }

    @Override
    public synchronized void addMessages(String loginFrom, String loginTo, String text) {
        User userFrom = this.userContainer.get(loginFrom);
        User userTo = this.userContainer.get(loginTo);
        this.messageMap.get(userTo)
                .add(new Message(userFrom, userTo, text))
        ;
    }

    @Override
    public List<Message> getMessages(String login) {
        User user = this.userContainer.get(login);
        return this.messageMap.get(user);
    }
}
