package com.franco.turnos.service;

import org.springframework.stereotype.Service;

import com.franco.turnos.dto.LocalRecord;
import com.franco.turnos.model.Local;
import com.franco.turnos.repository.LocalRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LocalService {

    private LocalRepository localRepository;

    public Local validate(LocalRecord record){
        Local local = new Local();
        if (!(record.nombre().isBlank() || record.nombre().isEmpty())){
            local.setNombre(record.nombre());
        } else throw new RuntimeException("El nombre del local no puede ser nulo");

        return local;
    }

    public long create(LocalRecord record){
        Local local;

        local = validate(record);
        localRepository.save(local);

        return local.getId();
    }

    public LocalRecord show(Long id){
        Local local = localRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el local"));

        return new LocalRecord(local.getNombre());
    }
    
}
