package com.user.service.system.event.sourcing.commands;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateUserCommand extends BaseCommand<Integer> {
    private final String name;

    private final String email;

    private final String password;

    private final LocalDate localDate;

    public UpdateUserCommand(Integer id, String name, String email, String password, LocalDate localDate) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.localDate = localDate;
    }
}
