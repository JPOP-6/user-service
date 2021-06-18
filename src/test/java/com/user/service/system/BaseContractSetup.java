package com.user.service.system;

import com.user.service.system.model.dto.UserDTO;
import com.user.service.system.service.UserService;
import io.restassured.config.EncoderConfig;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static wiremock.com.google.common.base.Charsets.UTF_8;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BaseContractSetup {

    @Autowired
    private WebApplicationContext context;

    @MockBean
    UserService userService;

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.config = new RestAssuredMockMvcConfig()
                .encoderConfig(new EncoderConfig(UTF_8.name(), UTF_8.name()));

        RestAssuredMockMvc.webAppContextSetup(context);

        Mockito.when(userService.getAllUsers()).thenReturn(getAllUsers());
        Mockito.when(userService.getUserById(1)).thenReturn(getUserById());
        Mockito.when(userService.addUser(any())).thenReturn(getUserById());
        Mockito.when(userService.updateUser(anyInt(), any())).thenReturn(getUserById());
    }

    private List<UserDTO> getAllUsers() {
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setId(1);
        userDTO1.setEmail("email1");
        userDTO1.setLocalDate(LocalDate.of(2021,06,18));
        userDTO1.setName("name1");
        userDTO1.setPassword("password1");
        userDTO1.setUsername("username1");
        UserDTO userDTO2 = new UserDTO();
        userDTO2.setId(2);
        userDTO2.setEmail("email2");
        userDTO2.setLocalDate(LocalDate.of(2021,06,18));
        userDTO2.setName("name2");
        userDTO2.setPassword("password2");
        userDTO2.setUsername("username2");
        return Arrays.asList(userDTO1, userDTO2);
    }

    private UserDTO getUserById() {
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setId(1);
        userDTO1.setEmail("email1");
        userDTO1.setLocalDate(LocalDate.of(2021,06,18));
        userDTO1.setName("name1");
        userDTO1.setPassword("password1");
        userDTO1.setUsername("username1");

        return userDTO1;
    }
}