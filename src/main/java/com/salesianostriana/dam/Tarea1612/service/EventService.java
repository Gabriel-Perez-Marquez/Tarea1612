package com.salesianostriana.dam.Tarea1612.service;

import com.salesianostriana.dam.Tarea1612.model.Event;
import com.salesianostriana.dam.Tarea1612.repository.OrganizerRepository;
import com.salesianostriana.dam.Tarea1612.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EventService {

    private final VenueRepository venueRepository;
    private final OrganizerRepository organizerRepository;

    public Event createEvent(String name, LocalDateTime date, Long venueId, Long organizerId){
        return Event.builder()
                .name(name)
                .date(date)
                .venue(venueRepository.findById(venueId).orElseThrow(() -> new RuntimeException("Venue not found")))
                .organizer(organizerRepository.findById(organizerId).orElseThrow(() -> new RuntimeException("Organizer not found")))
                .build();
    }
}
