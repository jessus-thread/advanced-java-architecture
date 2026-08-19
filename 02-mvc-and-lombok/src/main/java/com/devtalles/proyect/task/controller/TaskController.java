package com.devtalles.proyect.task.controller;

import com.devtalles.proyect.task.exceptions.TaskException;
import com.devtalles.proyect.task.exceptions.TaskValidationException;
import com.devtalles.proyect.task.model.Task;
import com.devtalles.proyect.task.model.TaskRepository;

import java.util.List;

public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public void addTask(String id, String title, String description, Boolean completed) throws TaskValidationException, TaskException {
        this.validateTaskData(id, title, description, completed);

        Task task = new Task(id, title, description, completed);

        this.taskRepository.save(task);

        System.out.println("The task was successfully added.");
    }

    public void removeTask(String id) throws TaskValidationException, TaskException {
        if (id == null || id.trim().isBlank()) {
            throw new TaskValidationException("The id cannot be empty");
        }

        this.taskRepository.remove(id);
    }

    public void showsTasks() throws TaskValidationException, TaskException {
        List<Task> tasks = this.taskRepository.findAll();

        if (tasks.isEmpty())
            throw new TaskValidationException("The list cannot be empty.");

        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void updateTask(String id, String title, String description, Boolean completed) throws TaskValidationException, TaskException {
        this.validateTaskData(id, title, description, completed);

        Task taskUpdated = new Task(id, title, description, completed);

        this.taskRepository.updateTask(taskUpdated);
    }

    private void validateTaskData(String id, String title, String description, Boolean completed) throws TaskValidationException {
        if (id == null || id.trim().isBlank()) {
            throw new TaskValidationException("The id cannot be empty");
        }

        if (title == null || title.trim().isBlank()) {
            throw new TaskValidationException("The title cannot be empty.");
        }

        if (description == null || description.trim().isBlank()) {
            throw new TaskValidationException("The description cannot be empty.");
        }

        if (completed == null) {
            throw new TaskValidationException("The state cannot be empty.");
        }
    }
}
