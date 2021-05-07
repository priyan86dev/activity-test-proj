package com.testactivity;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.testactivity.service.DummyUserService;

@SpringBootApplication
public class ActivityTestProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivityTestProjApplication.class, args);
	}

	@Bean
	public CommandLineRunner inti(final DummyUserService userService) {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				userService.createUsers();
			}
		};
	}
	
//	@Bean
//	InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {
//
//		return new InitializingBean() {
//			public void afterPropertiesSet() throws Exception {
//
//				Group group = identityService.newGroup("user");
//				group.setName("users");
//				group.setType("security-role");
//				identityService.saveGroup(group);
//
//				User admin = identityService.newUser("admin");
//				admin.setPassword("admin");
//				identityService.saveUser(admin);
//			}
//		};
//	}
}
