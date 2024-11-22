package com.franco.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franco.turnos.model.Profesional;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Long> {
    
}
