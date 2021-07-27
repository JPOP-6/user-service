package com.user.service.system.service;

import com.user.service.system.model.dto.UserDTO;

import java.util.concurrent.CompletableFuture;

public interface CommandService {
    public CompletableFuture<UserDTO> createUser(UserDTO userDTO);
    public CompletableFuture<UserDTO> updateUser(Integer id, UserDTO userDTO);
    public CompletableFuture<Object> deleteUser(Integer id);
}
