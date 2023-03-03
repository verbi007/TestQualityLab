package com.example.notebook.notebook.repo;

import com.example.notebook.notebook.models.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
