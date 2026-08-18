package com.devtalles.proyect.datastore;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataStore<User, String> userStore = new DataStore<>();

        try {
            System.out.println("Adding users");

            userStore.add("123", new User("123", "Fernando"));
            userStore.add("124", new User("124", "María"));
            userStore.add("125", new User("125", "Luis"));
            userStore.add("12346", new User("126", "Ana"));

            System.out.println("Found: " + userStore.find("123"));
            System.out.println("Deleted: " + userStore.remove("123"));
        } catch (NullPointerException error) {
            System.out.println(error.getMessage());
        }

        List<User> users = userStore.getAll();

        for (User user : users) {
            System.out.println(user);
        }
    }
}
