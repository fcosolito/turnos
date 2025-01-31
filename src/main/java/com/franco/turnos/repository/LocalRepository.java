package com.franco.turnos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.franco.turnos.model.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local, Long>{
    
}
