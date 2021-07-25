package com.user.service.system.event.sourcing.commands;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteUserCommand extends BaseCommand<Integer> {

    public DeleteUserCommand(Integer id) {
        super(id);
     }
}
