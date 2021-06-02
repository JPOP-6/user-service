package com.user.service.system.resource.impl;

import com.user.service.system.model.dto.UserDTO;
import com.user.service.system.resource.api.UserServiceResource;
import com.user.service.system.service.UserService;
import com.user.service.system.utility.UserServiceResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class UserServiceResourceImpl implements UserServiceResource {

    private final UserService userService;

    public UserServiceResourceImpl(@Autowired UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserServiceResult> getAllUsers() {
        ResponseEntity<UserServiceResult> responseEntity;
        UserServiceResult userServiceResult = new UserServiceResult();
        try {
            List<UserDTO> users = userService.getAllUsers();
            userServiceResult.setSuccess(true);
            userServiceResult.setUsers(users);
            responseEntity = ResponseEntity.ok(userServiceResult);
        } catch (Exception exception) {
            userServiceResult.setError(exception.getMessage());
            responseEntity = ResponseEntity.badRequest().body(userServiceResult);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<UserServiceResult> getUserById(int id) {
        ResponseEntity<UserServiceResult> responseEntity;
        UserServiceResult userServiceResult = new UserServiceResult();
        try {
            UserDTO user = userService.getUserById(id);
            userServiceResult.setSuccess(true);
            userServiceResult.setUsers(Collections.singletonList(user));
            responseEntity = ResponseEntity.ok(userServiceResult);
        } catch (Exception exception) {
            userServiceResult.setError(exception.getMessage());
            responseEntity = ResponseEntity.badRequest().body(userServiceResult);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<UserServiceResult> addUser(UserDTO userDTO) {
        ResponseEntity<UserServiceResult> responseEntity;
        UserServiceResult userServiceResult = new UserServiceResult();
        try {
            UserDTO user = userService.addUser(userDTO);
            userServiceResult.setSuccess(true);
            userServiceResult.setUsers(Collections.singletonList(user));
            responseEntity = ResponseEntity.ok(userServiceResult);
        } catch (Exception exception) {
            userServiceResult.setError(exception.getMessage());
            responseEntity = ResponseEntity.badRequest().body(userServiceResult);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<UserServiceResult> deleteUser(int id) {
        ResponseEntity<UserServiceResult> responseEntity;
        UserServiceResult userServiceResult = new UserServiceResult();
        try {
            userService.deleteUser(id);
            userServiceResult.setSuccess(true);
            responseEntity = ResponseEntity.ok(userServiceResult);
        } catch (Exception exception) {
            userServiceResult.setError(exception.getMessage());
            responseEntity = ResponseEntity.badRequest().body(userServiceResult);
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<UserServiceResult> updateUser(int id, UserDTO userDTO) {
        ResponseEntity<UserServiceResult> responseEntity;
        UserServiceResult userServiceResult = new UserServiceResult();
        try {
            UserDTO user = userService.updateUser(id, userDTO);
            userServiceResult.setSuccess(true);
            userServiceResult.setUsers(Collections.singletonList(user));
            responseEntity = ResponseEntity.ok(userServiceResult);
        } catch (Exception exception) {
            userServiceResult.setError(exception.getMessage());
            responseEntity = ResponseEntity.badRequest().body(userServiceResult);
        }
        return responseEntity;
    }
}
