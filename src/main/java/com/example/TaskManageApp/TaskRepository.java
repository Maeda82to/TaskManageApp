package com.example.TaskManageApp;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
	List<Task> findAll(Sort sort);
	Task findByTaskId(Long taskId);
}
