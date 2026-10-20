package org.example.menu;

import org.example.console.AnimalReader;
import org.example.console.ConsoleInput;
import org.example.model.Animal;
import org.example.shelter.Shelter;

public class ConsoleMenu {
    private final Shelter<Animal> shelter;
    private final ConsoleInput input;
    private final AnimalReader animalReader;

    public ConsoleMenu(Shelter<Animal> shelter, ConsoleInput input) {
        this.shelter = shelter;
        this.input = input;
        this.animalReader = new AnimalReader(input);
    }


    // loop menu start here, every case calls correct Shelter methods
    public void start(){

        // TODO:
        // Show menu in a loop
        // Read user input
        // Call correct 'Shelter' methods based on selected option

        while (true) {
            printMenu();
            String choice = input.readNonEmptyString("Choose an option: ");

            switch (choice) {
                case "1" -> shelter.addAnimal(animalReader.readAnimal());
                case "2" -> shelter.getAllAnimals();
                case "3" -> shelter.findBySpecies();
                case "4" -> shelter.findAvailableAnimals();
               // case "5" -> shelter.markAsAdopted();
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println(
                        "Unknown option"
                );
            }
        }
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
