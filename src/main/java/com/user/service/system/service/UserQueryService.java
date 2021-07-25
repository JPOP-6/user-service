package com.user.service.system.service;

import com.user.service.system.model.UserQuery;
import com.user.service.system.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserQueryService {
    private final QueryGateway queryGateway;
    private final EventStore eventStore;
    public CompletableFuture<UserDTO> findById(Integer id) {
        return this.queryGateway.query(
                new UserQuery(id),
                ResponseTypes.instanceOf(UserDTO.class)
        );
    }
    public List<Object> listEventsForAccount(Integer id) {
        return this.eventStore
                .readEvents(String.valueOf(id))
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }

}
