package it_academy.org.messenger.core.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private final LocalDateTime sentTime;
    private final User from;
    private final String text;

    public Message(User from, User to, String message) {
        checkParam(from, to);

        this.from = from;
        this.text = message;
        this.sentTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Time=" + sentTime.format(DateTimeFormatter.ofPattern("dd.MM.yy-HH:mm:ss")) +
                ", from: " + from +
                ", message : " + text;
    }

    /**
     * Check the correct params
     * @param from User who has sent massage
     * @param to - User who has taken message
     */
    private void checkParam(User from, User to) {
        if (from == null) {
            throw new IllegalArgumentException("Message isn't correct");
        }else if (to == null) {
            throw new IllegalArgumentException("User doesn't exist");
        }
    }
}
