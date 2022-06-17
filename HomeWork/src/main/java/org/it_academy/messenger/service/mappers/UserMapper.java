package org.it_academy.messenger.service.mappers;

import org.it_academy.messenger.dao.entity.User;
import org.it_academy.messenger.core.dto.enums.Role;
import org.it_academy.messenger.core.dto.UserDto;
import org.it_academy.messenger.service.mappers.api.IMapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserMapper implements IMapper<User, UserDto> {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private boolean isInvalid = false;
    private String errorMessage = "Invalid:";

    @Override
    public User get(UserDto dto) {
        checkParameter(dto.getLogin(), "login");
        checkParameter(dto.getPassword(), "password");
        checkParameter(dto.getFirstName(), "firstName");
        checkParameter(dto.getLastName(), "lastName");
        LocalDate birthday = getBirthday(dto.getBirthday());

        if (isInvalid) {
            throw new IllegalArgumentException(this.errorMessage);
        }

        User user = new User(
                dto.getLogin().toLowerCase(),
                dto.getPassword(),
                dto.getFirstName(),
                dto.getLastName(), birthday);

        user.setStatus(Role.USER);

        String thirdName = dto.getThirdName();

        if (thirdName != null && thirdName.length() != 0) {
            user.setThirdName(thirdName);
        }

        return user;
    }

    private void checkParameter(String str, String param) {
        if (str == null || str.length() == 0) {
            this.errorMessage += (!this.isInvalid ? " " : ", ") + param;
            this.isInvalid = true;
        }
    }

    private LocalDate getBirthday(String str) {
        if (str != null) {
            LocalDate date;

            try {
                date = LocalDate.parse(str, formatter);
                return date;

            }catch (DateTimeParseException e) {
                this.errorMessage +=
                        (!this.isInvalid ? " " : ", ") +
                        "birthday";
                this.isInvalid = true;
                return null;
            }
        }

        this.errorMessage += (!this.isInvalid ? " " : ", ") + "birthday";
        this.isInvalid = true;

        return null;
    }
}
