package com.example.TaskManageApp.task;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.TaskManageApp.task.Task.TaskPriority;
import com.example.TaskManageApp.task.Task.TaskStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskFormat {
	
	private String taskName;
	private String taskMemo;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate deadline;
	
	
	private TaskStatus status;
	private TaskPriority priority;
	private String category;
	
}
