package com.user.service.system.model.mapper;

import com.user.service.system.event.sourcing.commands.CreateUserCommand;
import com.user.service.system.event.sourcing.commands.UpdateUserCommand;
import com.user.service.system.model.User;
import com.user.service.system.model.dto.UserDTO;
import org.mapstruct.*;


@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserModelMapper {
    User toEntity(UserDTO UserDTO);

    User toEntity(CreateUserCommand event);

    UserDTO toDTO(CreateUserCommand event);

    @Mappings({
            @Mapping(target = "username", ignore = true)
    })
    User update(@MappingTarget User book, UserDTO UserDTO);

    @Mappings({
            @Mapping(target = "username", ignore = true)
    })
    User update(@MappingTarget User user, UpdateUserCommand updateUserCommand);

    @Mappings({
            @Mapping(target = "username", ignore = true)
    })
    UserDTO update(@MappingTarget UserDTO user, UpdateUserCommand updateUserCommand);

    UserDTO toDto(User book);
}
