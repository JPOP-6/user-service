package com.user.service.system.resource.impl;

import com.user.service.system.model.dto.UserDTO;
import com.user.service.system.resource.api.UserServiceResource;
import com.user.service.system.service.CommandServiceImpl;
import com.user.service.system.service.UserQueryService;
import com.user.service.system.utility.UserServiceResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class UserServiceResourceImpl implements UserServiceResource {

    private final UserQueryService userQueryService;

    private final CommandServiceImpl commandService;

    @Override
    public ResponseEntity<UserServiceResult> getAllUsers() {
        ResponseEntity<UserServiceResult> responseEntity;
        UserServiceResult userServiceResult = new UserServiceResult();
        try {
           // List<UserDTO> users = userQueryService.getAllUsers();
            userServiceResult.setSuccess(true);
            //userServiceResult.setUsers(users);
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
            UserDTO user = userQueryService.findById(id).get();
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
            Integer id = commandService.createUser(userDTO).get();
            userServiceResult.setSuccess(true);
            //userDTO = userQueryService.findById(id).get();
            //userServiceResult.setUsers(Collections.singletonList(userDTO));
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
            commandService.deleteUser(id);
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
            commandService.updateUser(id, userDTO).get();
            userServiceResult.setSuccess(true);
            //userDTO = userQueryService.findById(id).get();
            //userServiceResult.setUsers(Collections.singletonList(userDTO));
            responseEntity = ResponseEntity.ok(userServiceResult);
        } catch (Exception exception) {
            userServiceResult.setError(exception.getMessage());
            responseEntity = ResponseEntity.badRequest().body(userServiceResult);
        }
        return responseEntity;
    }
}
