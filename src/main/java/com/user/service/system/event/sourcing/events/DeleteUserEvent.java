package com.user.service.system.event.sourcing.events;

public class DeleteUserEvent extends BaseEvent<Integer>{
    public DeleteUserEvent(Integer id) {
        super(id);
    }
}
