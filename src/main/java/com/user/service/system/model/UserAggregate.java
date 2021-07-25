package com.user.service.system.model;

import com.user.service.system.event.sourcing.commands.CreateUserCommand;
import com.user.service.system.event.sourcing.commands.DeleteUserCommand;
import com.user.service.system.event.sourcing.commands.UpdateUserCommand;
import com.user.service.system.event.sourcing.events.CreateUserEvent;
import com.user.service.system.event.sourcing.events.DeleteUserEvent;
import com.user.service.system.event.sourcing.events.UpdateUserEvent;
import lombok.Data;
import lombok.experimental.FieldNameConstants;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import java.time.LocalDate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Data
@FieldNameConstants
@Aggregate
public class UserAggregate {

    @AggregateIdentifier
    private int id;

    private String name;

    private String username;

    private String email;

    private String password;

    private LocalDate localDate;

    @CommandHandler
    public UserAggregate(CreateUserCommand createUserCommand) {
        apply(new CreateUserEvent(createUserCommand.getId(), createUserCommand.getName(), createUserCommand.getUsername(),
                createUserCommand.getEmail(), createUserCommand.getPassword(), createUserCommand.getLocalDate()));
    }

    @EventSourcingHandler
    public void on(CreateUserEvent createUserEvent) {
        this.id = createUserEvent.id;
        this.name = createUserEvent.getName();
        this.username = createUserEvent.getUsername();
        this.email = createUserEvent.getEmail();
        this.password = createUserEvent.getPassword();
        this.localDate = createUserEvent.getLocalDate();
    }

    @CommandHandler
    public void handle(UpdateUserCommand updateUserCommand) {
        apply(new UpdateUserEvent(updateUserCommand.getId(), updateUserCommand.getName(),
                updateUserCommand.getEmail(), updateUserCommand.getPassword(), updateUserCommand.getLocalDate()));
    }

    @CommandHandler
    public void handle(DeleteUserCommand deleteUserCommand) {
        apply(new DeleteUserEvent(deleteUserCommand.getId()));
    }

    @EventSourcingHandler
    public void on(UpdateUserEvent updateUserEvent) {
        this.id = updateUserEvent.id;
        this.name = updateUserEvent.getName();
        this.email = updateUserEvent.getEmail();
        this.password = updateUserEvent.getPassword();
        this.localDate = updateUserEvent.getLocalDate();
    }

    @EventSourcingHandler
    public void on(DeleteUserEvent deleteUserEvent) {
        this.id = deleteUserEvent.id;
    }


}
