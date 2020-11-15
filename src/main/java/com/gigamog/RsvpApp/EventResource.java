package com.gigamog.RsvpApp;

import com.gigamog.RsvpApp.domain.Guest;
import com.gigamog.RsvpApp.domain.ScheduledEvent;
import com.gigamog.RsvpApp.domain.ScheduledEventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class EventResource {

    private final ScheduledEventRepository scheduledEventRepository;

    @PostMapping(path = "/event")
    public ScheduledEvent creatEvent(@Validated @RequestBody ScheduledEvent scheduledEvent) {
        return scheduledEventRepository.save(scheduledEvent);
    }

    @PostMapping(path = "/event/{id}/rsvp")
    public ResponseEntity rsvp(@Validated @RequestBody Guest guest, @PathVariable String id) {
        Optional<ScheduledEvent> scheduledEventOptional = scheduledEventRepository.findById(id);
        if (scheduledEventOptional.isPresent()) {
            ScheduledEvent scheduledEvent = scheduledEventOptional.get();
            scheduledEvent.getGuests().add(guest);
            scheduledEventRepository.save(scheduledEvent);
            return ResponseEntity.ok(scheduledEvent);
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/event")
    public List<ScheduledEvent> getEvents(Pageable pageable) {
        return scheduledEventRepository.findAll(pageable).getContent();
    }
}
