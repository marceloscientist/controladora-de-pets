package com.qintess.controladoradepets.controller;

import com.qintess.controladoradepets.exceptions.NameFoundException;
import com.qintess.controladoradepets.model.Pet;
import com.qintess.controladoradepets.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1/pets")
public class PetController {
    @Autowired
    private PetService petService;

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createPet(@RequestBody Pet pet) throws NameFoundException {
       petService.createPet(pet);
    }
}
