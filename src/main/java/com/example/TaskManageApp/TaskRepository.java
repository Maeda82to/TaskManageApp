package com.example.TaskManageApp;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {

	Task findByTaskId(Long taskId);
}
