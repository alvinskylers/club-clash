package com.alvinskylers.clubclash.service;

import com.alvinskylers.clubclash.dto.ClubDTO;

import java.util.List;

public interface ClubService {
    List<ClubDTO> findAllClubs();

    void createClub(ClubDTO clubDTO);

    ClubDTO findClubById(Long id);

    void updateClub(ClubDTO clubDTO);

    void delete(Long clubId);

    List<ClubDTO> searchClubs(String query);
}
