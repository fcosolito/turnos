package com.franco.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franco.turnos.model.Profesion;

@Repository
public interface ProfesionRepository extends JpaRepository<Profesion, Long>{
    
}
