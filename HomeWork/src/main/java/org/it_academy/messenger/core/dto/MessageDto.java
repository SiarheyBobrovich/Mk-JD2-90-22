package org.it_academy.messenger.core.dto;

import org.it_academy.messenger.dao.entity.User;

import java.time.LocalDateTime;

public class MessageDto {

    private final User from;
    private final String text;

    public MessageDto(User from, String text) {
        this.from = from;
        this.text = text;
    }


    public User getFrom() {
        return from;
    }

    public String getText() {
        return text;
    }
}
