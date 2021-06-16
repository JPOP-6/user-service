package com.user.service.system.resource.api;

import com.user.service.system.model.dto.UserDTO;
import com.user.service.system.utility.UserServiceResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
public interface UserServiceResource {
    @GetMapping("/")
    ResponseEntity<UserServiceResult> getAllUsers();

    @GetMapping("/{id}")
    ResponseEntity<UserServiceResult> getUserById(@PathVariable("id") int id);

    @PostMapping("/")
    ResponseEntity<UserServiceResult> addUser(@RequestBody UserDTO userDTO);

    @DeleteMapping("/{id}")
    ResponseEntity<UserServiceResult> deleteUser(@PathVariable("id") int id);

    @PutMapping("/{id}")
    ResponseEntity<UserServiceResult> updateUser(@PathVariable("id") int id, @RequestBody UserDTO userDTO);

}
