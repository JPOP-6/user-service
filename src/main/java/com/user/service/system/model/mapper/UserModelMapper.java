package com.user.service.system.model.mapper;

import com.user.service.system.model.User;
import com.user.service.system.model.dto.UserDTO;
import org.mapstruct.*;


@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserModelMapper {
    User toEntity(UserDTO UserDTO);

    @Mappings({
            @Mapping(target = "username", ignore = true)
    })
    User update(@MappingTarget User book, UserDTO UserDTO);

    UserDTO toDto(User book);
}
