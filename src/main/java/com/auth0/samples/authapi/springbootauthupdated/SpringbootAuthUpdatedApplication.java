package com.auth0.samples.authapi.springbootauthupdated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
// https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.auth0.samples.authapi.springbootauthupdated.task.Task;
import com.auth0.samples.authapi.springbootauthupdated.task.TaskRepository;
import com.auth0.samples.authapi.springbootauthupdated.user.ApplicationUser;
import com.auth0.samples.authapi.springbootauthupdated.user.ApplicationUserRepository;

// https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/

@SpringBootApplication
public class SpringbootAuthUpdatedApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringbootAuthUpdatedApplication.class);

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAuthUpdatedApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TaskRepository repository, ApplicationUserRepository userRepository) {
		return (args) -> {
			// save a couple of tasks
			Task t1 = new Task("Dinner with my Family");
			Task t2 = new Task("movie Night with my Family");
			Task t3 = new Task("Brunch with my Scholars");

			repository.save(t1);
			repository.save(t2);
			repository.save(t3);

			// fetch all tasks
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Task task : repository.findAll()) {
				log.info(task.toString());
			}
			log.info("");

			// fetch an individual Task by ID
			repository.findById(1L).ifPresent(task -> {
				log.info("Task found with findById(1L):");
				log.info("--------------------------------");
				log.info(task.toString());
				log.info("");
			});

			log.info("tasks");

			// save a couple of users
			ApplicationUser u1 = new ApplicationUser("user", "123");
			ApplicationUser u2 = new ApplicationUser("user1", "123");
			ApplicationUser u3 = new ApplicationUser("user2", "123");

			
			u1.setTask(t1);
			u2.setTask(t2);
			u3.setTask(t3);
			userRepository.save(u1);
			userRepository.save(u2);
			userRepository.save(u3);

			// fetch all tasks
			log.info("Users found with findAll():");
			log.info("-------------------------------");
			for (ApplicationUser user : userRepository.findAll()) {
				log.info(user.toString());
			}
			log.info("");

			// fetch an individual Task by ID
			repository.findById(1L).ifPresent(user -> {
				log.info("User found with findById(1L):");
				log.info("--------------------------------");
				log.info(user.toString());
				log.info("");
			});

			log.info("users");

		};
	}
}
