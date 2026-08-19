package com.devtalles.proyect;

import com.devtalles.proyect.task.controller.TaskController;
import com.devtalles.proyect.task.model.TaskRepository;
import com.devtalles.proyect.task.view.TaskView;

public class Main {
    static void main() {
        TaskRepository repository = new TaskRepository();
        TaskController controller = new TaskController(repository);
        TaskView view = new TaskView(controller);

        view.showMenu();
    }
}
