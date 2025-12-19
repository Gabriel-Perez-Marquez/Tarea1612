package com.salesianostriana.dam.Tarea1612.service;

import com.salesianostriana.dam.Tarea1612.model.Event;
import com.salesianostriana.dam.Tarea1612.model.EventState;
import com.salesianostriana.dam.Tarea1612.repository.EventRepository;
import com.salesianostriana.dam.Tarea1612.repository.OrganizerRepository;
import com.salesianostriana.dam.Tarea1612.repository.VenueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {
    private final EventRepository eventRepository;
    private final VenueRepository venueRepository;
    private final OrganizerRepository organizerRepository;

    public Event createEvent(String name, LocalDateTime date, Long venueId, Long organizerId, LocalDateTime startAt, LocalDateTime endAt){
        if(comprobarSolapamientoFechas(startAt, endAt, eventRepository.findAll())){
            return Event.builder()
                    .name(name)
                    .date(date)
                    .state(EventState.CREADO)
                    .venue(venueRepository.findById(venueId).orElseThrow(() -> new RuntimeException("Venue not found")))
                    .organizer(organizerRepository.findById(organizerId).orElseThrow(() -> new RuntimeException("Organizer not found")))
                    .build();
        } else {
            throw new RuntimeException("Error creating the event");
        }

    }


    public boolean comprobarSolapamientoFechas (LocalDateTime startAt, LocalDateTime endAt, List<Event> events){
        return events.stream().anyMatch((e2 -> startAt.isBefore(e2.getStartAt()) || endAt.isAfter(e2.getEndAt())));
    }


    public Event publishEvent (){

    }

}
