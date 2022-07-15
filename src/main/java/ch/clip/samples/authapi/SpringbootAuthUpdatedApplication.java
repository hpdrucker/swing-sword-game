package ch.clip.samples.authapi;

import ch.clip.samples.authapi.ability.Ability;
import ch.clip.samples.authapi.ability.AbilityRepository;
import ch.clip.samples.authapi.character.Character;
import ch.clip.samples.authapi.item.Item;
import ch.clip.samples.authapi.item.ItemRepository;
import ch.clip.samples.authapi.character.CharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
// https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.clip.samples.authapi.service.TaskUserService;
import ch.clip.samples.authapi.task.Task;
import ch.clip.samples.authapi.task.TaskRepository;
import ch.clip.samples.authapi.user.AppUser;
import ch.clip.samples.authapi.user.AppUserRepository;

// https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/
// https://github.com/auth0/java-jwt
@SpringBootApplication
public class SpringbootAuthUpdatedApplication {
	private static final Logger log = LoggerFactory.getLogger(SpringbootAuthUpdatedApplication.class);

	@Autowired
	private TaskUserService taskUserService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAuthUpdatedApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(TaskRepository taskRepository, AppUserRepository userRepository, CharacterRepository characterRepository, AbilityRepository abilityRepository, ItemRepository itemRepository) {
		return (args) -> {
			// save a couple of tasks
			Task t1 = new Task("Dinner with my Family");
			Task t2 = new Task("movie Night with my Family");
			Task t3 = new Task("Brunch with my Scholars");

			taskRepository.save(t1);
			taskRepository.save(t2);
			taskRepository.save(t3);

			Character c1 = new Character("Sakuya", 100, 50);

			characterRepository.save(c1);

			Ability a1 = new Ability("Slash", "10% Max Health Damage");
			Ability a2 = new Ability("BigSlash", "20% Max Health Damage");
			Ability a3 = new Ability("HugeSlash", "25% Max Health Damage");

			abilityRepository.save(a1);
			abilityRepository.save(a2);
			abilityRepository.save(a3);

			Item i1 = new Item("BlueBlade", 100);
			Item i2 = new Item("RedBlade", 200);

			itemRepository.save(i1);
			itemRepository.save(i2);


			// fetch all tasks
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Task task : taskRepository.findAll()) {
//				log.info(task.toString());
//			}
//			log.info("");
//
//			// fetch an individual Task by ID
//			taskRepository.findById(1L).ifPresent(task -> {
//				log.info("Task found with findById(1L):");
//				log.info("--------------------------------");
//				log.info(task.toString());
//				log.info("");
//			});
//
//			log.info("tasks");

			abilityRepository.findById(1L).ifPresent(ability -> {
				log.info("Ability found with findById(1L):");
				log.info("--------------------------------");
				log.info(ability.toString());
				log.info("");
			});



			log.info("abilites");

			characterRepository.findById(1L).ifPresent(character -> {
				log.info("Character found with findById(1L):");
				log.info("--------------------------------");
				log.info(character.toString());
				log.info("");
			});
			// save a couple of users
			AppUser u1 = new AppUser("user", "123");
			AppUser u2 = new AppUser("user1", "123");
			AppUser u3 = new AppUser("Olaf", "123");
			AppUser u4 = new AppUser("user4-service", "123");

			
			u1.setTask(t1);
			u2.setTask(t2);
			u3.setTask(t3);
			userRepository.save(u1);
			userRepository.save(u2);
			userRepository.save(u3);

			taskUserService.addTask(u4, 3L);



			
			// fetch all tasks
//			log.info("Users found with findAll():");
//			log.info("-------------------------------");
//			for (AppUser user : userRepository.findAll()) {
//				log.info(user.toString());
//			}
//			log.info("");
//
//			// fetch an individual Task by ID
//			taskRepository.findById(1L).ifPresent(user -> {
//				log.info("User found with findById(1L):");
//				log.info("--------------------------------");
//				log.info(user.toString());
//				log.info("");
//			});
//
//			log.info("users");

		};
	}
}
