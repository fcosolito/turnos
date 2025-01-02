package com.franco.turnos.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.franco.turnos.dto.ClienteRecord;
import com.franco.turnos.repository.ClienteRepository;
import com.franco.turnos.service.ClienteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/cliente")
public class ClienteController {
    private ClienteRepository clienteRepository;
    private ClienteService clienteService;

    // GET      /cliente/show?={id}
    // POST     /cliente/create?={params}
    // REMOVE   /cliente/destroy?={id}

    @GetMapping("/show")
    public ClienteRecord showCliente(@RequestParam long id){
        return clienteService.show(id);
    }

    @PostMapping("/create")
    public long createCliente(@RequestBody ClienteRecord cliente){
        return clienteService.create(cliente);
    }
    
    @DeleteMapping("/destroy")
    public void deleteCliente(@RequestParam Long id){
        clienteRepository.deleteById(id);
    }
}
