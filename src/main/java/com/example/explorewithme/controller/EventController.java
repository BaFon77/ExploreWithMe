package com.example.explorewithme.controller;

import com.example.explorewithme.dto.EventDTO;
import com.example.explorewithme.entity.Event;
import com.example.explorewithme.repository.EventRepository;
import com.example.explorewithme.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody EventDTO dto) {
        return mappingResponseEvent(eventService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<Event>> readAll() {
        return mappingResponseListEvent(eventService.readAll());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Event>> update(@PathVariable Long id) {
        return mappingResponseListEvent(eventService.readByCategoryId(id));
    }

    @PutMapping
    public ResponseEntity<Event> update(@RequestBody Event event) {
        return mappingResponseEvent(eventService.update(event));
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        eventService.delete(id);
        return HttpStatus.OK;
    }

    private ResponseEntity<Event> mappingResponseEvent(Event event) {
        return new ResponseEntity<>(event, HttpStatus.OK);
    }

    private ResponseEntity<List<Event>> mappingResponseListEvent(List<Event> events) {
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
}
