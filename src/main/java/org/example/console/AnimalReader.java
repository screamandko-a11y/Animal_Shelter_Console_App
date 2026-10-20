package org.example.console;

import org.example.model.Animal;


// reads animal details from the console and delegates creation to AnimalFactory
public class AnimalReader {
    private final ConsoleInput input;
    private final AnimalFactory animalFactory = new AnimalFactory();


    public AnimalReader(ConsoleInput input) {
        this.input = input;
    }

    public String readSpecies() {
        return input.readChoice("Type (Dog, Cat, Bird): ", "Dog", "Cat", "Bird");
    }


    public Animal readAnimal() {
        String species = readSpecies();
        String name = input.readNonEmptyString("Name: ");
        int age = input.readInt("Age: ", 0, Integer.MAX_VALUE);

        return animalFactory.create(species, name, age);
    }
}
