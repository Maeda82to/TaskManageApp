package com.example.TaskManageApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TaskController {
    
    @Autowired
    TaskRepository taskRepository; 
    
    @Autowired
    TaskService service;
    
    @GetMapping("/taskApp")
    public String getTask(Model model) {
        List<Task> taskList = service.getTaskList();
        model.addAttribute("taskList", taskList);
        return "taskApp";
    }
    
    @PostMapping("/added")
    public String addTask(@ModelAttribute TaskFormat form, Model model) {
        List<Task> taskList = service.addTaskList(form);
        model.addAttribute("taskList", taskList);
        return "redirect:/taskApp";
    }
    
    @PostMapping("/{taskId}/delete")
    public String deleteTask(@PathVariable long taskId, Model model) {
        List<Task> taskList = service.deleteTaskList(taskId);
        model.addAttribute("taskList", taskList);
        return "redirect:/taskApp";
    }
    
    @PostMapping("/{taskId}/modify")
    public String modifyTask(@PathVariable long taskId, Model model) {
    	Task task = taskRepository.findByTaskId(taskId);
    	model.addAttribute("task", task);
    	return "modifyTask";
    }
    
    @PostMapping("/updateTask")
    public String updateTask(@ModelAttribute Task task, Model model) {
    	
    	List<Task> taskList = service.modifyTaskList(task);
        model.addAttribute("taskList", taskList);
    	return "redirect:/taskApp";
    }
    
}
