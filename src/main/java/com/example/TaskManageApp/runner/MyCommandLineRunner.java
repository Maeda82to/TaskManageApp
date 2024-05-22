package com.example.TaskManageApp.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.TaskManageApp.task.TaskRepository;
import com.example.TaskManageApp.user.MyUserDetailsService;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	MyUserDetailsService userService;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("コマンドラインランナー実行開始");
		
//		//デモユーザを追加
//		userService.addUser("demo", "aaaa", RoleName.USER);
//
////		userService.encodeExistingUserPasswords();
//		
//		taskRepository.save(new Task("task1", TaskStatus.NOT_STARTED, TaskPriority.LOW));
//		taskRepository.save(new Task("task2", TaskStatus.IN_PROGRESS, TaskPriority.MEDIUM));
//		taskRepository.save(new Task("task3", TaskStatus.COMPLETED, TaskPriority.HIGH));
		
//		List<Task> taskList = taskRepository.findAll();
		
		System.out.println("コマンドラインランナー実行終了");
	}
}
