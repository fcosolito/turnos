package com.franco.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franco.turnos.model.Turno;

@Repository
public interface TurnoRepository extends JpaRepository<Turno, Long>{
    
}
