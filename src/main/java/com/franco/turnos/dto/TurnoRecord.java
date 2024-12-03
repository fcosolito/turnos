package com.franco.turnos.dto;

import java.time.LocalDateTime;

public record TurnoRecord(
    long clientId,
    long profesionalId,
    long localId,
    LocalDateTime horarioInicio,
    LocalDateTime horarioFin
) {}
