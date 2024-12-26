package com.franco.turnos.service;

import org.springframework.stereotype.Service;

import com.franco.turnos.dto.ProfesionRecord;
import com.franco.turnos.model.Profesion;
import com.franco.turnos.repository.ProfesionRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfesionService {
    
    private ProfesionRepository profesionRepository;

    public Profesion validate(ProfesionRecord record){
        Profesion profesion = new Profesion();
        if (!(record.nombre().isBlank() || record.nombre().isEmpty())){
            profesion.setNombre(record.nombre());
        } else throw new RuntimeException("El nombre de la profesion no puede ser nulo");
        if (profesionRepository.findById(record.padreId()).isPresent()){
            profesion.setPadre(profesionRepository.findById(record.padreId()).get());
        } else throw new RuntimeException("La profesion indicada como padre no existe");

        return profesion;
    }

    public long create(ProfesionRecord record){
        Profesion profesion;

        profesion = validate(record);
        profesionRepository.save(profesion);

        return profesion.getId();
    }

    public ProfesionRecord show(Long id){
        Profesion profesion = profesionRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la profesion"));
        Profesion padre = profesion.getPadre();
        Long padreId;
        if (padre == null){
            padreId = 0L;
        } else {
            padreId = padre.getId();
        }
        return new ProfesionRecord(profesion.getNombre(), padreId);
    }
    
}
