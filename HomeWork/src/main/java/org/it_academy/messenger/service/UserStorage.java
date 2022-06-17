package org.it_academy.messenger.service;

import org.it_academy.messenger.core.dto.MessageDto;
import org.it_academy.messenger.dao.entity.Message;
import org.it_academy.messenger.dao.entity.User;
import org.it_academy.messenger.core.dto.UserDto;
import org.it_academy.messenger.service.api.IUserStorage;
import org.it_academy.messenger.service.mappers.MessageMapper;
import org.it_academy.messenger.service.mappers.UserMapper;
import org.it_academy.messenger.service.mappers.api.IMapper;
import org.it_academy.messenger.core.dto.enums.Role;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserStorage implements IUserStorage {

    private static final UserStorage storage = new UserStorage();
    private final Map<String, User> userContainer;
    private final Map<User, List<Message>> messageMap;

    private UserStorage() {
        this.userContainer = new ConcurrentHashMap<>();
        this.messageMap = new ConcurrentHashMap<>();

        addAdmin();
    }

    @Override
    public User get(String authenticator) {
        return userContainer.get(authenticator.toLowerCase());
    }

    @Override
    public boolean check(String authenticator, String password) {
        if (authenticator == null || authenticator.isEmpty()){
            throw new IllegalArgumentException("Invalid login/password!");
        }

        User user = userContainer.get(authenticator.toLowerCase());

        if (user == null || !user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid login/password!");
        }

        return true;
    }

    @Override
    public void save(UserDto uDto) {
        IMapper<User, UserDto> factory = new UserMapper();
        User user = factory.get(uDto);

        if (userContainer.containsKey(user.getLogin())){
            throw new IllegalArgumentException("This login's already exist!");
        }

        this.userContainer.put(user.getLogin(), user);

        this.messageMap.put(user, new ArrayList<>());
    }

    @Override
    public void addMessage(MessageDto messageDto, String loginTo) {

        if (loginTo == null || loginTo.isEmpty()) {
            throw new IllegalArgumentException("Please enter the user's login");
        }

        loginTo = loginTo.toLowerCase();
        User fromUser = messageDto.getFrom();
        User toUser = this.userContainer.get(loginTo);

        Message message = new MessageMapper().get(messageDto);

        if (fromUser == null) {
            throw new IllegalStateException("Please sing in!");

        }else if (toUser == null) {
            throw new IllegalArgumentException("User doesn't exist!");

        } else if (messageDto.getText() == null || messageDto.getText().length() == 0) {
            throw new IllegalArgumentException("Enter the message!");
        }

        this.messageMap.get(toUser).add(message);
        StatisticStorage.getInstance().incrementCountMessages();
    }

    @Override
    public List<Message> getMessages(User user) {

        return this.messageMap.get(user);
    }

    private void addAdmin() {
        UserDto build = UserDto.create()
                .setLogin("admin")
                .setPassword("admin")
                .setFirstName("Siarhey")
                .setLastName("Unknown")
                .setBirthday("1987-06-27")
                .build();

        save(build);

        this.userContainer.get("admin").setStatus(Role.ADMIN);
    }

    public static UserStorage getInstance() {
        return storage;
    }
}
