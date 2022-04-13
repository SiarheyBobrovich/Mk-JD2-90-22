package it_academy.org.authorisation.dto;

import java.time.LocalDateTime;

public class Message {
    private final LocalDateTime sendTime;
    private final User from;
    private final User to;
    private final String message;

    public Message(User from, User to, String message) {
        this.from = from;
        this.to = to;
        this.message = message;
        this.sendTime = LocalDateTime.now();
    }
}
