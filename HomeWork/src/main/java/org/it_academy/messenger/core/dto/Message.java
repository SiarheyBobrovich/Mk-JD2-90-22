package org.it_academy.messenger.core.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private final LocalDateTime sentTime;
    private final User from;
    private final String text;

    public Message(User from, User to, String message) {
        checkParam(from, to, message);

        this.from = from;
        this.text = message;
        this.sentTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return sentTime.format(DateTimeFormatter.ofPattern("dd.MM.yy-HH:mm:ss")) +
                ", from: " + from +
                ", message : " + text;
    }

    /**
     * Check the correct params
     * @param from User who has sent massage
     * @param to - User who has taken message
     */
    private void checkParam(User from, User to, String text) {
        if (from == null) {
            throw new IllegalStateException("Please sing in!");

        }else if (to == null) {
            throw new IllegalArgumentException("User doesn't exist!");

        } else if (text == null || text.length() == 0) {
            throw new IllegalArgumentException("Enter the message!");
        }
    }
}
