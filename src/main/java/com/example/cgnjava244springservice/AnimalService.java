package com.example.cgnjava244springservice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public List<Animal> getAnimals() {
        return animalRepository.findAll();
    }

    public Animal save(NewAnimal newAnimal) {
        Animal newAnimal2 = new Animal(UUID.randomUUID().toString(), newAnimal.name(), newAnimal.age(), 0);
       return  animalRepository.save(newAnimal2);
    }
}
