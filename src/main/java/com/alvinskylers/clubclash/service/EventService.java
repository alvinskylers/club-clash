package com.alvinskylers.clubclash.service;

import com.alvinskylers.clubclash.dto.EventDTO;

public interface EventService {

    void addEvent(Long clubId, EventDTO eventDTO);
}
