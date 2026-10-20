package org.example.console;

import org.example.model.Animal;
import org.example.model.AnimalId;
import org.example.model.Bird;
import org.example.model.Cat;
import org.example.model.Dog;
import org.example.model.Mouse;

// creates animals from supplied details
public class AnimalFactory {
    public Animal create(String species, String name, int age) {
        AnimalId id = new AnimalId();

        return switch (species) {
            case "Dog" -> new Dog(id, name, age);
            case "Cat" -> new Cat(id, name, age);
            case "Bird" -> new Bird(id, name, age);
            case "Mouse" -> new Mouse(id, name, age);
            default -> throw new IllegalArgumentException("Unknown species: " + species);
        };
    }
}
