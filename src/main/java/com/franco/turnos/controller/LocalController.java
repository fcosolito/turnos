package com.franco.turnos.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.franco.turnos.dto.LocalRecord;
import com.franco.turnos.repository.LocalRepository;
import com.franco.turnos.service.LocalService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/local")
public class LocalController {

    private LocalRepository localRepository;
    private LocalService localService;

    // GET      /local/show?={id}
    // POST     /local/create?={params}
    // REMOVE   /local/destroy?={id}

    @GetMapping("/show")
    public LocalRecord showLocal(@RequestParam long id){
        return localService.show(id);
    }

    @PostMapping("/create")
    public long createLocal(@RequestBody LocalRecord profesion){
        return localService.create(profesion);
    }
    
    @DeleteMapping("/destroy")
    public void deleteLocal(@RequestParam Long id){
        localRepository.deleteById(id);
    }
    
}
