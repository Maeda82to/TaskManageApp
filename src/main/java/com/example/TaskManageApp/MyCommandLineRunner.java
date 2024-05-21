package com.example.TaskManageApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
	
	@Autowired
	TaskRepository taskRepository;
	@Autowired
	MyUserDetailsService userService;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("コマンドラインランナー実行開始");
		
		//デモユーザを追加
		userService.addUser("demo", "aaaa", RoleName.USER);

//		userService.encodeExistingUserPasswords();
		
		taskRepository.save(new Task("task1"));
		taskRepository.save(new Task("task2"));
		taskRepository.save(new Task("task3"));
		
//		List<Task> taskList = taskRepository.findAll();
		
		System.out.println("コマンドラインランナー実行終了");
	}
}
