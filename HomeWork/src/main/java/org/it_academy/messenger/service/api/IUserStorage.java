package org.it_academy.messenger.service.api;

import org.it_academy.messenger.core.dto.MessageDto;
import org.it_academy.messenger.core.dto.UserDto;
import org.it_academy.messenger.dao.entity.Message;
import org.it_academy.messenger.dao.entity.User;

public interface IUserStorage extends IStorage<User, UserDto, Message, MessageDto>{
}
