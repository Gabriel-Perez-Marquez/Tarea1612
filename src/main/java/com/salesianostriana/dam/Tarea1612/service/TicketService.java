package com.salesianostriana.dam.Tarea1612.service;

import com.salesianostriana.dam.Tarea1612.model.Attendee;
import com.salesianostriana.dam.Tarea1612.model.Event;
import com.salesianostriana.dam.Tarea1612.model.Ticket;
import com.salesianostriana.dam.Tarea1612.model.TicketType;
import com.salesianostriana.dam.Tarea1612.repository.AttendeeRepository;
import com.salesianostriana.dam.Tarea1612.repository.EventRepository;
import com.salesianostriana.dam.Tarea1612.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final EventRepository eventRepository;
    private final AttendeeRepository attendeeRepository;
    private final TicketRepository ticketRepository;

    public Ticket buyTicket (Long eventId, Long attendeeId, TicketType ticketType, double price) {
        Event e = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        Attendee a = attendeeRepository.findById(attendeeId).orElseThrow(() -> new RuntimeException("Attendee not found"));

        for(int i = 0; i<a.getTickets().size(); i++){
            if(a.getTickets().get(i).getEvent() == e && a.getTickets().get(i).getType() == ticketType){
                throw new RuntimeException("Ya tiene una entrada de ese tipo para este evento");
            }
        }

        Ticket ticket = Ticket.builder()
                .type(ticketType)
                .price(price)
                .purchasedAt(LocalDateTime.now())
                .attendee(a)
                .event(e)
                .build();

        ticketRepository.save(ticket);

        return ticket;
    }


    public List<Ticket> showTicketsByEvent (Long eventId) {

        return eventRepository.findById(eventId).orElseThrow().getTickets();
    }


}
