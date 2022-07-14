package ch.clip.samples.authapi.service;

import org.springframework.stereotype.Service;

import ch.clip.samples.authapi.task.Task;
import ch.clip.samples.authapi.task.TaskRepository;
import ch.clip.samples.authapi.user.AppUser;
import ch.clip.samples.authapi.user.AppUserRepository;

@Service
public class TaskUserServiceImpl implements TaskUserService {

	private TaskRepository taskRepository;
	private AppUserRepository appUserRepository;

	public TaskUserServiceImpl(TaskRepository taskRepository, AppUserRepository appUserRepository) {
		this.appUserRepository = appUserRepository;
		this.taskRepository = taskRepository;
	}

	@Override
	public void addTask(AppUser user, Long taskId) {
		// add the task to the user
		Task task = taskRepository.getOne(taskId);
		user.setTask(task);
		appUserRepository.save(user);
		
	}

}
