package org.it_academy.messenger.dao.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Message {
    private LocalDateTime sentTime;
    private User from;
    private String text;

    public Message(User from, String message) {
        this.from = from;
        this.text = message;
        this.sentTime = LocalDateTime.now();
    }

    public LocalDateTime getSentTime() {
        return sentTime;
    }

    public void setSentTime(LocalDateTime sentTime) {
        this.sentTime = sentTime;
    }

    public User getFrom() {
        return from;
    }

    public void setFrom(User from) {
        this.from = from;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return sentTime.format(DateTimeFormatter.ofPattern("dd.MM.yy-HH:mm:ss")) +
                ", from: " + from +
                ", message : " + text;
    }

}
