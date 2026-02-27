package com.alvinskylers.clubclash.service.implementation;

import com.alvinskylers.clubclash.dto.EventDTO;
import com.alvinskylers.clubclash.models.Club;
import com.alvinskylers.clubclash.models.Event;
import com.alvinskylers.clubclash.repository.ClubRepository;
import com.alvinskylers.clubclash.repository.EventRepository;
import com.alvinskylers.clubclash.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void addEvent(Long clubId, EventDTO eventDTO) {
        Club club = clubRepository.findClubById(clubId);
        Event event = mapToEvent(eventDTO);
        event.setClub(club);
        eventRepository.save(event);
    }

    private Event mapToEvent(EventDTO eventDTO) {
        return Event.builder()
                .id(eventDTO.getId())
                .title(eventDTO.getTitle())
                .type(eventDTO.getType())
                .photoURL(eventDTO.getPhotoURL())
                .content(eventDTO.getContent())
                .startTime(eventDTO.getStartTime())
                .endTime(eventDTO.getEndTime())
                .createdOn(eventDTO.getCreatedOn())
                .updatedOn(eventDTO.getUpdatedOn())
                .build();
    }
}
