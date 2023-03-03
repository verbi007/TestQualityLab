package com.example.notebook.notebook.controllers;

import com.example.notebook.notebook.models.Task;
import com.example.notebook.notebook.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {

    @Autowired
    private TaskRepository taskRepository;


    @GetMapping("/")
    public String mainTaskAll(Model model) {
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("title", "JumboBook");
        return "home";
    }

    @GetMapping("/customers")
    public String goToCustomers(Model model) {
        model.addAttribute("title", "Customers");
        return "customers";
    }
}
