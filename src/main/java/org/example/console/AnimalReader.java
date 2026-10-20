package org.example.console;

import lombok.RequiredArgsConstructor;
import org.example.model.Animal;


// reads animal details from the console and delegates creation to AnimalFactory

@RequiredArgsConstructor
public class AnimalReader {
    private final ConsoleInput input;
    private final AnimalFactory animalFactory = new AnimalFactory();

    public String readSpecies() {
        return input.readChoice("Type (Dog, Cat, Bird, Mouse): ", "Dog", "Cat", "Bird", "Mouse");
    }


    public Animal readAnimal() {
        String species = readSpecies();
        String name = input.readNonEmptyString("Name: ");
        int age = input.readNonNegativeInt("Age: ");

        return animalFactory.create(species, name, age);
    }
}
