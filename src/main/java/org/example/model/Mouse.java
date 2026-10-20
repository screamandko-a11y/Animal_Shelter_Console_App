package org.example.model;


// new other type of animal
public final class Mouse extends Animal {

    public Mouse(AnimalId id, String name, int age){
        super(id,name,age);
    }

    @Override
    public String getSpecies(){
        return "Mouse";
    }
}


