package org.example.shelter;

import org.example.console.AnimalReader;
import org.example.console.ConsoleInput;
import org.example.model.Animal;

import java.util.ArrayList;
import java.util.List;

public class Shelter <T extends Animal>{
    private final List<T> animals = new ArrayList<>();
    private final AnimalReader animalReader;

    public Shelter(ConsoleInput input) {
        this.animalReader = new AnimalReader(input);
    }

    public void addAnimal(T animal){
        animals.add(animal);
    }

    public List<T> getAllAnimals(){
        System.out.println("All animals in shelter :" + animals);
        return animals;
    }

    public void findBySpecies() {
        String species = animalReader.readSpecies();
        boolean found = false;

        for (T animal : animals) {
            if (animal.getSpecies().equalsIgnoreCase(species)) {
                System.out.println(animal);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No animals found.");
        }
    }

    public List<T> findAvailableAnimals(){
        // TODO
        return null;
    }

    public void markAsAdopted(String id){
        // TODO
    }
}
