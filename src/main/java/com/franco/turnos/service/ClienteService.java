package com.franco.turnos.service;

import org.springframework.stereotype.Service;

import com.franco.turnos.dto.ClienteRecord;
import com.franco.turnos.model.Cliente;
import com.franco.turnos.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository localRepository;

    public Cliente validate(ClienteRecord record){
        Cliente cliente = new Cliente();
        if (!(record.nombre().isBlank() || record.nombre().isEmpty())){
            cliente.setNombre(record.nombre());
        } else throw new RuntimeException("El nombre del cliente no puede ser nulo");
        if (!(record.apellido().isBlank() || record.apellido().isEmpty())){
            cliente.setApellido(record.apellido());
        } else throw new RuntimeException("El apellido del cliente no puede ser nulo");

        return cliente;
    }

    public long create(ClienteRecord record){
        Cliente cliente;

        cliente = validate(record);
        localRepository.save(cliente);

        return cliente.getId();
    }

    public ClienteRecord show(Long id){
        Cliente cliente = localRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el cliente"));

        return new ClienteRecord(cliente.getNombre(), cliente.getApellido());
    }
    
}
