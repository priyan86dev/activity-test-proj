package com.testactivity.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testactivity.data.entity.DummyUser;
import com.testactivity.data.repository.DummyUserRepository;

@Service
public class DummyUserService {

	@Autowired
	private DummyUserRepository userRepository;

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@Autowired
	private RepositoryService repositoryService;

	public String processStart(String asignee) {
		DummyUser dUser = userRepository.findByName(asignee);

		Map<String, Object> variables = new HashMap<>();
		variables.put("dummyUser", dUser);

		runtimeService.startProcessInstanceByKey("simple-process", variables);
		return processLog();
	}

	public List<Task> getTasks(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}

	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}

	public String processLog() {

		List<Task> tasks = taskService.createTaskQuery().orderByTaskCreateTime().asc().list();
		StringBuilder info = new StringBuilder();
		info.append("NO Of Processes :" + repositoryService.createProcessDefinitionQuery().count());
		tasks.forEach(task -> {
			info.append("ID: " + task.getId() + ", Name: " + task.getName() + ", Assignee: " + task.getAssignee()
					+ ", Description: " + task.getDescription());
		});
		return info.toString();
	}

	public void createUsers() {
		if (userRepository.findAll().size() == 0) {
			userRepository.save(new DummyUser(1, "aaaa", "superuser"));
			userRepository.save(new DummyUser(2, "bbbb", "user"));
		}
	}
}
