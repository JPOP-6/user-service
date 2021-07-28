package com.user.service.system.service;

import com.user.service.system.model.dto.UserDTO;

import java.util.concurrent.CompletableFuture;

public interface CommandService {
    public CompletableFuture<Integer> createUser(UserDTO userDTO);
    public CompletableFuture<Integer> updateUser(Integer id, UserDTO userDTO);
    public CompletableFuture<Integer> deleteUser(Integer id);
}
