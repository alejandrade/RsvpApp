package com.gigamog.RsvpApp.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledEventRepository extends PagingAndSortingRepository<ScheduledEvent, String> {
}
