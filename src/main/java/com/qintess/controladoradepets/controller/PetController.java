package com.qintess.controladoradepets.controller;

import com.qintess.controladoradepets.exceptions.NameFoundException;
import com.qintess.controladoradepets.model.Pet;
import com.qintess.controladoradepets.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1/pets")
//@RequestMapping("/api")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("/pets")
    public ResponseEntity<List<Pet>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable("id") long id) {
        return petService.getPetById(id);
    }

    @PostMapping("/pets")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPet(@RequestBody Pet pet) throws NameFoundException {
       petService.createPet(pet);
    }
}
