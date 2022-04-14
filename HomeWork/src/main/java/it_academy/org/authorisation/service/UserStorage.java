package it_academy.org.authorisation.service;

import it_academy.org.authorisation.dto.enums.Role;
import it_academy.org.authorisation.dto.User;
import it_academy.org.authorisation.service.api.IStorage;

import java.util.HashMap;
import java.util.Map;

public class UserStorage implements IStorage {

    private static UserStorage storage = new UserStorage();
    private final Map<String, User> userContainer;

    private UserStorage() {
        this.userContainer = new HashMap<>();
        User user = new UserFactory().getUser("admin", "admin",
                "Siarhey", "Bobrovich", "Alexandrovich",
                "27.06.1987"

        );

        user.setStatus(Role.ADMIN);
        this.userContainer.put(user.getPassword(), user);
    }

    public static UserStorage getInstance() {
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
    public void save(User user) {
        if (userContainer.containsKey(user.getLogin())){
            throw new IllegalArgumentException("This login's already exist");
        }

        this.userContainer.put(user.getLogin(), user);
    }
}
