package com.user.service.system.event.sourcing.events;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateUserEvent extends BaseEvent<Integer>{
    private final String name;

    private final String username;

    private final String email;

    private final String password;

    private final LocalDate localDate;

    public CreateUserEvent(int id, String name, String username, String email, String password, LocalDate localDate) {
        super(id);
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.localDate = localDate;
    }
}
