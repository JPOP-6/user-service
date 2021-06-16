package com.user.service.system;

import com.user.service.system.model.mapper.UserModelMapperImpl;
import com.user.service.system.repositories.UserRepository;
import com.user.service.system.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {
		UserRepository.class
})
@EntityScan("com.user.service.system.model")
@Import(value = {
		UserService.class,
		UserModelMapperImpl.class
})
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
