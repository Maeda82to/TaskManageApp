package com.example.TaskManageApp.task;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;
	
	public List<Task> getTaskList() {
		
		List<Task> taskList = taskRepository.findAll();
		
		return taskList;
		
	}
	
	public List<Task> addTaskList(TaskFormat form){
		
		List<Task> taskList = taskRepository.findAll();
		
		Task t = new Task(form);
		taskRepository.save(t);
		
		taskList = taskRepository.findAll();
		
		return taskList;
	}
	
	public List<Task> deleteTaskList(long id){
		
		taskRepository.deleteById(id);
		
		List<Task> list = taskRepository.findAll();
		
		return list;
	}
	
	public List<Task> modifyTaskList(Task task){
		//フォームから送信されたタスク情報を更新
		
		Task exTask = taskRepository.findByTaskId(task.getTaskId());
		
		exTask.setTaskName(task.getTaskName());
		exTask.setTaskMemo(task.getTaskMemo());
		exTask.setDeadline(task.getDeadline());
		exTask.setStatus(task.getStatus());
		exTask.setPriority(task.getPriority());
		exTask.setCategory(task.getCategory());
		exTask.setUpdatedAt(LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
		
		taskRepository.save(exTask);
	
		List<Task> list = taskRepository.findAll();
		
		return list;
	}
}
