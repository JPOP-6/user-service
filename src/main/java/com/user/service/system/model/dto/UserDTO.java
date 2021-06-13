package com.user.service.system.model.dto;

import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@Data
@FieldNameConstants
public class UserDTO {

    private int id;

    private String name;

    private String username;

    private String email;

    private String password;

    private LocalDate localDate;
}
