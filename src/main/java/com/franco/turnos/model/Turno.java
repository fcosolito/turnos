package com.franco.turnos.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFin;
    @ManyToOne
    private Profesional profesional;
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Local local;
    
}
