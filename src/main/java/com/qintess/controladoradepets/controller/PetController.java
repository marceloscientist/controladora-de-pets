package com.qintess.controladoradepets.controller;

import com.qintess.controladoradepets.model.Pet;
import com.qintess.controladoradepets.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PetController {


    @Autowired
    private PetRepository petRepository;

    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }
    
}
