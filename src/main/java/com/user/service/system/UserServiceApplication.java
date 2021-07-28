package com.user.service.system;

import com.user.service.system.model.mapper.UserModelMapperImpl;
import com.user.service.system.repositories.UserRepository;
import com.user.service.system.service.CommandServiceImpl;
import com.user.service.system.service.UserQueryService;
import com.user.service.system.service.UserService;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.SimpleCommandBus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.DefaultCommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
		UserRepository.class
})
@EntityScan(basePackages = {
		"org.axonframework.eventsourcing.eventstore.jpa",
		"org.axonframework.eventhandling.tokenstore.jpa",
		"org.axonframework.modelling.saga.repository.jpa",
		"com.user.service.system.model",
		"com.user.service.system.model.dto"
})
@Import(value = {
		UserService.class,
		UserModelMapperImpl.class,
		UserQueryService.class,
		CommandServiceImpl.class
})
@EnableDiscoveryClient
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
