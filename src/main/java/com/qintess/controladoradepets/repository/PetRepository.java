package com.qintess.controladoradepets.repository;

import com.qintess.controladoradepets.model.Pet;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public
interface PetRepository extends JpaRepository<Pet, Long> {
    Optional<Pet> findByNome (String nome);
}
