package com.franco.turnos.service;

import org.springframework.stereotype.Service;

import com.franco.turnos.model.Turno;
import com.franco.turnos.repository.TurnoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TurnoService {

    private TurnoRepository turnoRepository;

    public boolean validate(Turno turno){
        boolean result = true;

        return result;

    }

    
}
