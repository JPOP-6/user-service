package com.user.service.system.service;

import com.user.service.system.event.sourcing.commands.CreateUserCommand;
import com.user.service.system.event.sourcing.events.DeleteUserEvent;
import com.user.service.system.event.sourcing.events.UpdateUserEvent;
import com.user.service.system.model.dto.UserDTO;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CommandServiceImpl implements CommandService {

    private final CommandGateway commandGateway;

    public CommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<UserDTO> createUser(UserDTO userDTO) {
        return commandGateway.send(new CreateUserCommand(userDTO.getName(),
                userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword(),
                userDTO.getLocalDate()));
    }

    @Override
    public CompletableFuture<UserDTO> updateUser(Integer id, UserDTO userDTO) {
        return commandGateway.send(new UpdateUserEvent(id, userDTO.getName(),
                userDTO.getEmail(), userDTO.getPassword(),
                userDTO.getLocalDate()));
    }

    @Override
    public CompletableFuture<Object> deleteUser(Integer id) {
        return commandGateway.send(new DeleteUserEvent(id));
    }

}
