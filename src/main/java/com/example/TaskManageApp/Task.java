package com.example.TaskManageApp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private long taskId = 0;
	
	private String taskName = "";
	private String taskMemo = "";
	
	private LocalDate deadline = LocalDate.now();
	
	private LocalDateTime createdAt = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
	
	private LocalDateTime updatedAt = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
	
	private String category = "未選択";
	private TaskStatus status = TaskStatus.NOT_STARTED;
	
	private TaskPriority priority = TaskPriority.LOW;
	
	public enum TaskStatus{
		NOT_STARTED,
		IN_PROGRESS,
		COMPLETED
	}
	
	public enum TaskPriority{
		LOW,
		MEDIUM,
		HIGH
	}
	
	
	public Task(TaskFormat form) {
		this.taskName = form.getTaskName();
		this.taskMemo = form.getTaskMemo();
		this.deadline = form.getDeadline();
		this.status = form.getStatus();
		this.priority = form.getPriority();
		this.category = form.getCategory();
		
	}
//	//nameとmemoを受け取るコンストラクタ
//	public Task(TaskFormat form) {
//		this.taskName = form.name;
//	}
//	
}
