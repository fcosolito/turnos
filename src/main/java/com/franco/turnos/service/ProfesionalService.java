package com.franco.turnos.service;

import org.springframework.stereotype.Service;

import com.franco.turnos.dto.ProfesionalRecord;
import com.franco.turnos.model.Profesional;
import com.franco.turnos.repository.ProfesionRepository;
import com.franco.turnos.repository.ProfesionalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfesionalService {

    private ProfesionalRepository profesionalRepository;
    private ProfesionRepository profesionRepository;

    public Profesional validate(ProfesionalRecord record){
        Profesional profesional =  new Profesional();
        if (!(record.nombre().isBlank() || record.nombre().isEmpty())){
            profesional.setNombre(record.nombre());
        } else throw new RuntimeException("El nombre del profesional no puede ser nulo");
        if (!(record.apellido().isBlank() || record.apellido().isEmpty())){
            profesional.setApellido(record.apellido());
        } else throw new RuntimeException("El apellido del profesional no puede ser nulo");
        if (profesionRepository.findById(record.profesionId()).isPresent()){
            profesional.setProfesion(profesionRepository.findById(record.profesionId()).get());
        } else throw new RuntimeException("La profesion no se encuentra registrada");
        
        return profesional;
    }

    public long create(ProfesionalRecord record) {
        Profesional profesional = validate(record);
        
        profesional = profesionalRepository.save(profesional);

        return profesional.getId();
    }
    
}
