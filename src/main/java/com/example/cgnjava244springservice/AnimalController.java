package com.example.cgnjava244springservice;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
@RequiredArgsConstructor
public class AnimalController {

    private final AnimalService animalService;

    @GetMapping()
    public List<ApiAnimal> getAnimals() {
        List<Animal> animals = animalService.getAnimals();
        return animals.stream()
                .map(animal -> new ApiAnimal(animal.id(), animal.name(), animal.age()))
                .toList();
    }

    @PostMapping()
    public ApiAnimal postAnimal(@RequestBody NewAnimal newAnimal) {
        Animal newAnimal2 = animalService.save(newAnimal);
        return new ApiAnimal(newAnimal2.id(), newAnimal2.name(), newAnimal2.age());
    }

}
