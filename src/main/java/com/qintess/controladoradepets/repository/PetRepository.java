package com.qintess.controladoradepets.repository;

import com.qintess.controladoradepets.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface PetRepository extends JpaRepository<Pet, Long> {

}
