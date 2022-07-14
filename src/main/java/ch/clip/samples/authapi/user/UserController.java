package ch.clip.samples.authapi.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.clip.samples.authapi.service.TaskUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	private AppUserRepository applicationUserRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private TaskUserService taskUserService;

	public UserController(AppUserRepository applicationUserRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.applicationUserRepository = applicationUserRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@PostMapping("/sign-up")
	public void signUp(@RequestBody AppUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		applicationUserRepository.save(user);

	}

	@PostMapping("/{id}")
	public void addUser(@RequestBody AppUser user, @PathVariable Long id) { // , @RequestBody Task task) {
		// service methode user, id -> Service taak getById user.setTask
		taskUserService.addTask(user, id);
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping
	public List<AppUser> getUsers() {
		return applicationUserRepository.findAll(); // taskRepository.findAll();
	}

}
