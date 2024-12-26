package com.franco.turnos.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.franco.turnos.dto.ProfesionRecord;
import com.franco.turnos.model.Profesion;
import com.franco.turnos.repository.ProfesionRepository;
import com.franco.turnos.service.ProfesionService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/profesion")
public class ProfesionController {

    private ProfesionRepository profesionRepository;
    private ProfesionService profesionService;

    // GET      /profesion/show?={id}
    // POST     /profesion/create?={params}
    // REMOVE   /profesion/destroy?={id}

    @GetMapping("/show")
    public ProfesionRecord showProfesion(@RequestParam long id){
        return profesionService.show(id);
    }

    @PostMapping("/create")
    public long createProfesion(@RequestBody ProfesionRecord profesion){
        log.info("Received post to /profesion/create");
        return profesionService.create(profesion);
    }
    
    @DeleteMapping("/destroy")
    public void deleteProfesion(@RequestParam Long id){
        profesionRepository.deleteById(id);
    }
    
}
