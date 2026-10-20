package org.example.menu;

import org.example.model.Animal;
import org.example.shelter.Shelter;
import org.example.model.AnimalId;
import org.example.model.Dog;
import org.example.model.Cat;
import org.example.model.Bird;

import java.util.Scanner;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final Scanner scanner =  new Scanner(System.in);
    public ConsoleMenu(Shelter<Animal> shelter) {
        this.shelter = shelter;
    }

    public void start(){

        // TODO:
        // Show menu in a loop
        // Read user input
        // Call correct 'Shelter' methods based on selected option

        while (true) {
            printMenu();
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addAnimal();
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println(
                        "Unknown option or feature not implemented yet."
                );
            }
        }


    }

    private void addAnimal() {
        System.out.print("Type (Dog, Cat, Bird): ");
        String type = scanner.nextLine().trim();

        System.out.print("Name: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Age: ");
        int age;

        try {
            age = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Age must be an integer.");
            return;
        }

        if (age < 0) {
            System.out.println("Age cannot be negative.");
            return;
        }

        Animal animal;

        switch (type.toLowerCase(java.util.Locale.ROOT)) {
            case "dog" -> animal = new Dog(new AnimalId(), name, age);
            case "cat" -> animal = new Cat(new AnimalId(), name, age);
            case "bird" -> animal = new Bird(new AnimalId(), name, age);
            default -> {
                System.out.println("Unknown animal type.");
                return;
            }
        }

        shelter.addAnimal(animal);
        System.out.println("Animal added: " + animal);
    }

    private void printMenu(){
        System.out.println("""
                1. Add animal
                2. List all animals
                3. Find animals by species
                4. List available animals
                5. Mark animal as adopted
                0. Exit
                """);
    }
}
