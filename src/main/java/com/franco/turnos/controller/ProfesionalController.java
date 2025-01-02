package com.franco.turnos.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.franco.turnos.dto.ProfesionalRecord;
import com.franco.turnos.repository.ProfesionalRepository;
import com.franco.turnos.service.ProfesionalService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/profesional")
public class ProfesionalController {

    private ProfesionalService profesionalService;
    private ProfesionalRepository profesionalRepository;
    
    // GET          /profesional/new
    // POST         /profesional/create?={params}
    // GET          /profesional/show?={id}
    // GET          /profesional/edit?={id}
    // POST         /profesional/update?={id, params}
    // DELETE       /profesional/destroy?={id}
    // GET          /profesional/search?={params}

    @GetMapping("/new")
    public void newProfesional(){
        // fetch the profesions available
        // display a form to enter the data
        // create a new profesional using /create

    }

    @PostMapping("/create")
    public long createProfesional(@RequestBody ProfesionalRecord profesional){
        return profesionalService.create(profesional);
    }

    @GetMapping("/show")
    public ProfesionalRecord showProfesional(@RequestParam Long id){
        return profesionalService.show(id);
    }

    @DeleteMapping("/destroy")
    public void destroyProfesional(@RequestParam Long id){
        profesionalRepository.deleteById(id);
    }
}
