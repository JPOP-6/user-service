package com.user.service.system.service;

import com.user.service.system.model.User;
import com.user.service.system.model.dto.UserDTO;
import com.user.service.system.model.mapper.UserModelMapper;
import com.user.service.system.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final UserModelMapper userModelMapper;

    public UserService(@Autowired UserRepository userRepository,
                       @Autowired UserModelMapper userModelMapper) {
        this.userRepository = userRepository;
        this.userModelMapper = userModelMapper;
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userModelMapper::toDto).collect(Collectors.toList());
    }

    public UserDTO getUserById(int id) {
        User user = userRepository.getById(id);
        return userModelMapper.toDto(user);
    }

    public UserDTO addUser(UserDTO UserDTO) {
        User user = userModelMapper.toEntity(UserDTO);
        user = userRepository.save(user);
        return userModelMapper.toDto(user);
    }

    public void deleteUser(int id) {
        User user = userRepository.getById(id);
        userRepository.delete(user);
    }

    public UserDTO updateUser(int id, UserDTO UserDTO) {
        if (userRepository.existsById(id)) {
            User user = userRepository.getById(id);
            user = userModelMapper.update(user, UserDTO);
            user.setId(id);
            user = userRepository.save(user);
            return userModelMapper.toDto(user);
        }
        return null;
    }
}
