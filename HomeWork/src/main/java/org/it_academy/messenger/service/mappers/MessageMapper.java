package org.it_academy.messenger.service.mappers;

import org.it_academy.messenger.core.dto.MessageDto;
import org.it_academy.messenger.dao.entity.Message;
import org.it_academy.messenger.service.mappers.api.IMapper;

public class MessageMapper implements IMapper<Message, MessageDto> {
    @Override
    public Message get(MessageDto messageDto) {
        return new Message(messageDto.getFrom(), messageDto.getText());
    }
}
