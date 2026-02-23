package com.alvinskylers.clubclash.service;

import com.alvinskylers.clubclash.dto.ClubDTO;
import com.alvinskylers.clubclash.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();

    Club createClub(Club club);
}
