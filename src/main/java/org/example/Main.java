package org.example;

import org.example.console.ConsoleInput;
import org.example.console.AnimalFactory;
import org.example.menu.ConsoleMenu;
import org.example.model.Animal;
import org.example.shelter.Shelter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the Animal Shelter!");

        // create shelter object
        ConsoleInput input = new ConsoleInput(new Scanner(System.in));
        Shelter<Animal> shelter = new Shelter<>(input);

        // pre-load some data
        AnimalFactory animalFactory = new AnimalFactory();
        shelter.addAnimal(animalFactory.create("Dog", "Buddy", 3));
        shelter.addAnimal(animalFactory.create("Cat", "Luna", 5));
        shelter.addAnimal(animalFactory.create("Bird", "Kiwi", 1));
        shelter.addAnimal(animalFactory.create("Mouse", "Snowball", 2));

        // create a ConsoleMenu object
        ConsoleMenu consoleMenu = new ConsoleMenu(shelter, input);
        // start the menu loop
        consoleMenu.start();
    }
}
