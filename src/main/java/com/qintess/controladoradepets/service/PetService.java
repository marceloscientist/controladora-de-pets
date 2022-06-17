package com.qintess.controladoradepets.service;

import com.qintess.controladoradepets.exceptions.NameFoundException;
import com.qintess.controladoradepets.model.Pet;
import com.qintess.controladoradepets.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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
        if(!petRepository.findByNome(pet.getNome())) {
            petRepository.save(pet);
        } else {
            throw new NameFoundException("Pet com mesmo nome encontrado");
        }
    }
}
