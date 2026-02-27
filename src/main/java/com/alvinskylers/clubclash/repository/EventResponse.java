package com.alvinskylers.clubclash.repository;

import com.alvinskylers.clubclash.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventResponse extends JpaRepository<Event, Long> {
}
