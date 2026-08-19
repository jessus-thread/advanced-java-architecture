package com.devtalles.proyect.task.view;

import com.devtalles.proyect.task.controller.TaskController;
import com.devtalles.proyect.task.exceptions.TaskException;
import com.devtalles.proyect.task.exceptions.TaskValidationException;
import com.devtalles.proyect.task.model.Task;

import java.util.Scanner;

public class TaskView {
    private final TaskController taskController;
    private final Scanner scanner;

    public TaskView(TaskController taskController) {
        this.taskController = taskController;
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n Task management");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Update Task");
            System.out.println("4. Show Task");
            System.out.println("5. Go out");

            System.out.println("Select an action: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    addTaskView();

                    break;
                case "2":
                    removeTaskView();

                    break;
                case "3":
                    updateTaskView();

                    break;
                case "4":
                    showTaskView();

                    break;
                case "5":
                    System.out.println("Exiting the system");

                    return;
                default:
                    System.out.println("Invalid option, please try again");
            }
        }
    }

    public void addTaskView() {
        try {
            Task task = getTaskInput();

            taskController.addTask(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted());

            System.out.println("Added Task");
        } catch (TaskValidationException | TaskException error) {
            System.out.println("Error " + error.getMessage());
        } catch (Exception error) {
            System.out.println("Unexpected error, please contact support");
            error.printStackTrace();
        }
    }

    public void removeTaskView() {
        try {
            String id = this.createInputString("Enter the ID to delete");

            this.taskController.removeTask(id);

            System.out.println("Task successfully deleted");
        } catch (TaskValidationException | TaskException error) {
            System.out.println("Error " + error.getMessage());
        } catch (Exception error) {
            System.out.println("Unexpected error, please contact support");
            error.printStackTrace();
        }
    }

    public void showTaskView() {
        try {
            System.out.println("\n The to-do list");

            this.taskController.showsTasks();
        } catch (TaskValidationException | TaskException error) {
            System.out.println("Error " + error.getMessage());
        } catch (Exception error) {
            System.out.println("Unexpected error, please contact support");
            error.printStackTrace();
        }
    }

    public void updateTaskView() {
        try {
            Task task = getTaskInput();

            taskController.updateTask(task.getId(), task.getTitle(), task.getDescription(), task.getCompleted());

            System.out.println("Updated Task");
        } catch (TaskValidationException | TaskException error) {
            System.out.println("Error " + error.getMessage());
        } catch (Exception error) {
            System.out.println("Unexpected error, please contact support");
            error.printStackTrace();
        }
    }

    private Task getTaskInput() {
        String id;

        do {
            id = this.createInputString("Enter ID: ");

            if (id.isEmpty()) {
                System.out.println("The id cannot be empty");
            }
        } while (id.trim().isEmpty());

        String title;

        do {
            title = this.createInputString("Enter title: ");

            if (title.isEmpty()) {
                System.out.println("The title cannot be empty");
            }
        } while (title.trim().isEmpty());

        String description;

        do {
            description = this.createInputString("Enter description: ");

            if (description.isEmpty()) {
                System.out.println("The description cannot be empty");
            }
        } while (description.trim().isEmpty());

        Boolean completed = null;

        while (completed == null) {
            String input = this.createInputString("this is complete? true/false").trim().toLowerCase();

            if (input.equals("true")) {
                completed = true;
            } else if (input.equals("false")) {
                completed = false;
            } else {
                System.out.println("The value entered is incorrect, please enter true or false");
            }
        }

        return new Task(id, title, description, completed);
    }

    private String createInputString(String label) {
        System.out.println(label);

        return scanner.nextLine();
    }
}
