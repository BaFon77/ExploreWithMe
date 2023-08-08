package com.example.explorewithme.service;

import com.example.explorewithme.dto.EventDTO;
import com.example.explorewithme.entity.Event;
import com.example.explorewithme.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;

    public Event create(EventDTO dto) {
        return eventRepository.save(Event.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .build());
    }

    public List<Event> readAll() {
        return eventRepository.findAll();
    }

    public Event update(Event event) {
        return eventRepository.save(event);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
