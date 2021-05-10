# activity-test-proj
Creating work-flows using spring activity module

# rest end points

1. Assigning task to user.  


	http://localhost:8080/process?assignee=${user.name}
	
2. View tasks by user.

	http://localhost:8080/tasks?assignee=${user.name}
	
3. Complete tasks by taskId.

	http://localhost:8080/completetask?taskId=${task.id}
	
