package org.example.shelter;

import org.example.console.AnimalReader;
import org.example.console.ConsoleInput;
import org.example.model.Animal;
import org.example.model.AdoptionStatus;

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

    public List<T> findAvailableAnimals() {
        List<T> availableAnimals = new ArrayList<>();

        for (T animal : animals) {
            if (animal.getAdoptionStatus() == AdoptionStatus.AVAILABLE) {
                availableAnimals.add(animal);
            }
        }
        System.out.println(availableAnimals);
        return availableAnimals;
    }



    public void markAsAdopted(String id){
        // TODO
    }
}
