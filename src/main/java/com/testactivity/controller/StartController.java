package com.testactivity.controller;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

	@Autowired
	private RuntimeService runtimeService;

	@RequestMapping("/start-process")
	public String startProcess() {

		runtimeService.startProcessInstanceByKey("myProcess");
		return "Process Started. No of currently running processes = "
				+ runtimeService.createProcessInstanceQuery().count();
	}
}
