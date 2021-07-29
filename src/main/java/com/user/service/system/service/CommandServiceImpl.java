package com.user.service.system.service;

import com.user.service.system.event.sourcing.commands.CreateUserCommand;
import com.user.service.system.event.sourcing.commands.DeleteUserCommand;
import com.user.service.system.event.sourcing.commands.UpdateUserCommand;
import com.user.service.system.event.sourcing.events.DeleteUserEvent;
import com.user.service.system.event.sourcing.events.UpdateUserEvent;
import com.user.service.system.model.dto.UserDTO;
import com.user.service.system.model.mapper.UserModelMapperImpl;
import com.user.service.system.repositories.UserRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CommandServiceImpl implements CommandService {

    private final CommandGateway commandGateway;
    private final UserService userService;

    public CommandServiceImpl(CommandGateway commandGateway, UserRepository userRepository, UserModelMapperImpl userModelMapper, UserService userService) {
        this.commandGateway = commandGateway;
        this.userService = userService;
    }

    @Override
    public CompletableFuture<Integer> createUser(UserDTO userDTO) {
       return commandGateway.send(new CreateUserCommand(userDTO.getName(),
                userDTO.getUsername(), userDTO.getEmail(), userDTO.getPassword(),
                userDTO.getLocalDate()));

    }

    @Override
    public CompletableFuture<Integer> updateUser(Integer id, UserDTO userDTO) {
        return commandGateway.send(new UpdateUserCommand(id, userDTO.getName(),
                userDTO.getEmail(), userDTO.getPassword(),
                userDTO.getLocalDate()));
    }

    @Override
    public CompletableFuture<Integer> deleteUser(Integer id) {
        return commandGateway.send(new DeleteUserCommand(id));
    }

}
