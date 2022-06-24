package com.qintess.controladoradepets.service;

import com.qintess.controladoradepets.exceptions.NameFoundException;
import com.qintess.controladoradepets.model.Pet;
import com.qintess.controladoradepets.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public
class PetService {

    @Autowired
    private PetRepository petRepository;

    public
    List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public
    void createPet(@RequestBody Pet pet) throws NameFoundException {
        Optional<Pet> petData = petRepository.findByNome(pet.getNome());
        if(petData.isEmpty()) {
            petRepository.save(pet);
        } else {
            throw new NameFoundException("Pet com mesmo nome encontrado");
        }
    }

    public ResponseEntity<Pet> getPetById(@PathVariable("id") long id) {
        Optional<Pet> petData = petRepository.findById(id);
        return petData.map(pet -> new ResponseEntity<>(pet, HttpStatus.ACCEPTED)).orElseGet(( ) -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
