package com.salesianostriana.dam.Tarea1612.repository;

import com.salesianostriana.dam.Tarea1612.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
}
