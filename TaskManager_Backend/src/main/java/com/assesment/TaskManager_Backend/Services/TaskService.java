package com.assesment.TaskManager_Backend.Services;

import com.assesment.TaskManager_Backend.Entitites.Task;
import com.assesment.TaskManager_Backend.Repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // create a new task
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // get all tasks
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // get a task by id
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // update a task
    public Task updateTask(Long id, Task taskDetails) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setTitle(taskDetails.getTitle());
                    task.setDescription(taskDetails.getDescription());
                    task.setStatus(taskDetails.getStatus());
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found with id " + id));
    }

    // delete a task
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
