package com.salesianostriana.dam.Tarea1612.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @ToString
@Builder
public class Organizer {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

}
