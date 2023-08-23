package com.example.explorewithme.service;

import com.example.explorewithme.dto.EventDTO;
import com.example.explorewithme.entity.Event;
import com.example.explorewithme.repository.CategoryRepository;
import com.example.explorewithme.repository.EventRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final CategoryService categoryService;

    public Event create(EventDTO dto) {
        return eventRepository.save(Event.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .description(dto.getDescription())
                .category(categoryService.readById(dto.getCategoryId()))
                .build());
    }

    public List<Event> readAll() {
        return eventRepository.findAll();
    }

    public List<Event> readByCategoryId(Long id) {
        return eventRepository.findByCategoryId(id);
    }

    public Event update(Event event) {
        return eventRepository.save(event);
    }

    public void delete(Long id) {
        eventRepository.deleteById(id);
    }
}
