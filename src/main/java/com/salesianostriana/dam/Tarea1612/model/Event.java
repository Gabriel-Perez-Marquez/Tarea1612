package com.salesianostriana.dam.Tarea1612.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
@Builder
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    private LocalDateTime date;

    private EventState state;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @ManyToOne
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @OneToMany(mappedBy = "event")
    @Builder.Default
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    @Builder.Default
    private List<StaffAssignment> staff = new ArrayList<>();

    private LocalDateTime startAt;
    private LocalDateTime endAt;


    public boolean comprobarValidez(){
        return this.organizer != null && this.venue != null;
    }

}
