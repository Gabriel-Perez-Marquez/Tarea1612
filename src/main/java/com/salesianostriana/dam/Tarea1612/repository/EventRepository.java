package com.salesianostriana.dam.Tarea1612.repository;

import com.salesianostriana.dam.Tarea1612.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
