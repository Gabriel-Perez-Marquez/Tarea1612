package com.salesianostriana.dam.Tarea1612.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
@Builder
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private TicketType type;

    private Double price;
    private LocalDateTime purchasedAt;


    @ManyToOne
    @JoinColumn(name = "attendee_id")
    private Attendee attendee;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;



}

