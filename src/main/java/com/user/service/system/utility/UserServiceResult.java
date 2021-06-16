package com.user.service.system.utility;

import com.user.service.system.model.dto.UserDTO;
import lombok.Data;

import java.util.List;

@Data
public class UserServiceResult {
    private boolean isSuccess;
    private String error;
    private List<UserDTO> users;
}
