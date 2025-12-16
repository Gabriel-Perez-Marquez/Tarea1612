package com.salesianostriana.dam.Tarea1612.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class StaffAssignment {

    @ManyToOne
    @JoinColumn(name = "attendee_id")
    private Attendee attendee;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @Enumerated(EnumType.STRING)
    private StaffRole role;

    private LocalDateTime shiftStart;
    private LocalDateTime shiftEnd;
    private boolean paid;
}
