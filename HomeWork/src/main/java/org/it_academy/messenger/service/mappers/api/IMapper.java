package org.it_academy.messenger.service.mappers.api;

public interface IMapper<U, DTO> {
    U get(DTO dto);
}
