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
public class Venue {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int capacity;

    @OneToMany(mappedBy = "venue", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Event> events = new ArrayList<>();


}
