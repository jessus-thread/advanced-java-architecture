package com.devtalles.proyect.task.model;

import com.devtalles.proyect.task.exceptions.TaskException;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    List<Task> tasks = new ArrayList<>();

    public void save(Task task) throws TaskException {
        if (task == null)
            throw new TaskException("The task cannot be null");

        tasks.add(task);
    }

    public Task findById(String id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }

        return null;
    }

    public void remove(String id) throws TaskException {
        Task task = findById(id);

        if (task == null)
            throw new TaskException("The task cannot be null");

        tasks.remove(task);
    }

    public void remove(Task task) throws TaskException {
        if (task == null)
            throw new TaskException("The task cannot be null");

        if (!tasks.contains(task))
            throw new TaskException("The task does not exist in list");

        tasks.remove(task);
    }

    public List<Task> findAll() throws TaskException {
        if (tasks.isEmpty())
            throw new TaskException("List is empty");

        return this.tasks;
    }

    public int findIndexById(String id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }

    public void updateTask(Task taskToUpdate) throws TaskException {
        if (taskToUpdate == null)
            throw new TaskException("The task cannot be null");

        int index = findIndexById(taskToUpdate.getId());

        if (index == -1)
            throw new TaskException("The task does not exist in list");

        tasks.set(index, taskToUpdate);
    }
}
