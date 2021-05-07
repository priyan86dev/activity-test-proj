package com.testactivity.controller;

import java.util.List;

import org.activiti.engine.task.Task;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.testactivity.service.DummyUserService;

@RestController
public class StartController {

//	@Autowired
//	private RuntimeService runtimeService;
//
//	@RequestMapping("/start-process")
//	public String startProcess() {
//
//		runtimeService.startProcessInstanceByKey("myProcess");
//		return "Process Started. No of currently running processes = "
//				+ runtimeService.createProcessInstanceQuery().count();
//	}

	private DummyUserService userService;

	public StartController(DummyUserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/process")
	public String startProcessInstance(@RequestParam String assignee) {
		return userService.processStart(assignee);
	}

	@RequestMapping(value = "/tasks")
	public String getTasks(@RequestParam("assignee") String assignee) {
		List<Task> tasks = userService.getTasks(assignee);
		return tasks.toString();
	}

	@RequestMapping(value = "/completetask")
	public String completeTask(@RequestParam String taskId) {
		userService.completeTask(taskId);
		return "Task with id " + taskId + " has been completed!";
	}

}
