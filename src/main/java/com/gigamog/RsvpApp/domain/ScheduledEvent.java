package com.gigamog.RsvpApp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "scheduled_event")
public class ScheduledEvent {
    @Id
    private String id = UUID.randomUUID().toString();
    @NonNull
    @Indexed
    private Date startDate;
    private Date endDate;
    private List<Guest> guests = new ArrayList<>();
}
