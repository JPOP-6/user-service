package com.user.service.system.event.sourcing.commands;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateUserCommand extends BaseCommand<Integer> {
    private final String name;

    private final String username;

    private final String email;

    private final String password;

    private final LocalDate localDate;
    private static int number = 1;

    public CreateUserCommand(String name, String username, String email, String password, LocalDate localDate) {
        super(number++);
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.localDate = localDate;
    }
}
