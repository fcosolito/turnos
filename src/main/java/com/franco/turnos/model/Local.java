package com.franco.turnos.model;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Local {
    private long id;
    private String nombre;
    
}
