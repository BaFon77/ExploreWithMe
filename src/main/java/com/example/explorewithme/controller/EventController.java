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
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public ResponseEntity<Event> create(@RequestBody EventDTO dto) {
        return new ResponseEntity<>(eventService.create(dto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Event>> readAll() {
        return new ResponseEntity<>(eventService.readAll(), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Event> update(@RequestBody Event event) {
        return new ResponseEntity<>(eventService.update(event), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable Long id) {
        eventService.delete(id);
        return HttpStatus.OK;
    }
}
