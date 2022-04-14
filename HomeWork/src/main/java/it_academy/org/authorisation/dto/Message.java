package it_academy.org.authorisation.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private final LocalDateTime sendTime;
    private final User from;
    private final User to;
    private final String message;

    public Message(User from, User to, String message) {
        checkParam(from, to);

        this.from = from;
        this.to = to;
        this.message = message;
        this.sendTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Time=" + sendTime.format(DateTimeFormatter.ofPattern("dd.MM.yy-HH:mm:ss")) +
                ", from: " + from +
                ", message : " + message;
    }

    private void checkParam(User from, User to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Message isn't correct");
        }
    }
}
