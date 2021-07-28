package com.user.service.system.service;

import com.user.service.system.event.sourcing.events.CreateUserEvent;
import com.user.service.system.event.sourcing.events.DeleteUserEvent;
import com.user.service.system.event.sourcing.events.UpdateUserEvent;
import com.user.service.system.model.UserQuery;
import com.user.service.system.model.dto.UserDTO;
import com.user.service.system.model.mapper.UserModelMapperImpl;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserProjection {
    private final UserService userService;

    private final UserModelMapperImpl userModelMapper;

    @EventHandler
    public void on(CreateUserEvent event) {
        UserDTO user = userModelMapper.toDTO(event);
        this.userService.addUser(user);
    }

    @EventHandler
    public void on(UpdateUserEvent event) {
        UserDTO userDTO = userModelMapper.update(new UserDTO(), event);
        this.userService.updateUser(event.id, userDTO);
    }

    @EventHandler
    public void on(DeleteUserEvent event) {
       this.userService.deleteUser(event.id);
    }

    @QueryHandler
    public UserDTO handle(UserQuery userQuery) {
        return this.userService.getUserById(userQuery.getId());
    }

}
