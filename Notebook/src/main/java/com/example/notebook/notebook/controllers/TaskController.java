package com.example.notebook.notebook.controllers;

import com.example.notebook.notebook.models.Task;
import com.example.notebook.notebook.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;


    @GetMapping("/tasks")
    public String tasksAll(Model model) {
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("title", "Заметки");
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String tasksAll(@PathVariable(value = "id") Long id, Model model) {
        Optional<Task> task = taskRepository.findById(id);
        ArrayList<Task> res = new ArrayList<>();
        task.ifPresent(res::add);
        model.addAttribute("task", res);
        model.addAttribute("title", "Заметка");
        return "task-details";
    }

    @GetMapping("/tasks/add")
    public String taskAdd(Model model) {
        model.addAttribute("title", "Добавление заметки");
        return "task-add";
    }

    @PostMapping("/tasks/add")
    public String taskPostAdd(@RequestParam String username, @RequestParam String email, @RequestParam String title,
                              @RequestParam String text, @RequestParam String country, @RequestParam String city, Model model) {
        Task task = new Task(username, email, title, text, country, city);
        taskRepository.save(task);
        model.addAttribute("title", "Заметки");
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/{id}/remove")
    public String taskRemove(@PathVariable(value = "id") Long id, Model model) {
        taskRepository.deleteById(id);
        return "redirect:/tasks";
    }
}
