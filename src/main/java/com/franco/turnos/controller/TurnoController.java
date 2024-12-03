package com.franco.turnos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.franco.turnos.model.Turno;
import com.franco.turnos.service.TurnoService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping(value = "/turno")
public class TurnoController {
    
    private TurnoService turnoService;
    // GET          /turno/new
    // POST         /turno/create?={params}
    // GET          /turno/show?={id}
    // GET          /turno/edit?={id}
    // POST         /turno/update?={id, params}
    // DELETE       /turno/destroy?={id}

    // Setup a form with available profesionals and dates for a selected profesional
    @GetMapping("/new")
    public void newTurno(){
        // Use the object ids to represent the selected objects
        // Use the client controller to display the client search 
        // clientController.search()
        // once a client is selected use the profesional
        // controller to display the profesional search 
        // profesionalController.search()
        // once a profesional is selected find its appointments and fill a datepicker with them
        // allowing to select only dates with some appointment time available
        // once a date is picked, fill a hour picker with the appointment data
        // once an available appointment time is selected and confirmed create the appointment
    }

    @PostMapping("/create")
    public Turno createTurno(@RequestBody Turno turno){
        return null;
    }
    
}
