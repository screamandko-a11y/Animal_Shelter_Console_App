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


    // add animal to the shelter
    public void addAnimal(T animal){
        animals.add(animal);
    }

    // print and return List of the Animals
    public List<T> getAllAnimals(){
        System.out.println("All animals in shelter :" + animals);
        return animals;
    }

    // print and return the List of Animals sorted by Species
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

    // print and return the List of Available Animals
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

    // print that animal is adopted
    public void markAsAdopted(String id) {
        for (T animal : animals) {
            if (animal.getId().toString().equals(id)) {
                animal.markAsAdopted();
                System.out.println("Animal marked as adopted");
                return;
            }
        }

        System.out.println("Animal not found");
    }
}
