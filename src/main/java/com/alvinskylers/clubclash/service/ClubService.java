package com.alvinskylers.clubclash.service;

import com.alvinskylers.clubclash.dto.ClubDTO;
import com.alvinskylers.clubclash.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();

    Club createClub(ClubDTO clubDTO);

    ClubDTO findClubById(Long id);

    void updateClub(ClubDTO clubDTO);

    void delete(Long clubId);
}
