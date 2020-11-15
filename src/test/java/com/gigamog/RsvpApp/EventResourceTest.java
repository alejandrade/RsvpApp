package com.gigamog.RsvpApp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gigamog.RsvpApp.domain.ScheduledEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EventResourceTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void test1() throws JsonProcessingException {
        ScheduledEvent scheduledEvent = new ScheduledEvent();
        scheduledEvent.setStartDate(new Date());
        System.out.println(new ObjectMapper().writeValueAsString(scheduledEvent));
    }
}