package com.alvinskylers.clubclash.repository;

import com.alvinskylers.clubclash.dto.ClubDTO;
import com.alvinskylers.clubclash.models.Club;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends Repository<Club, Long> {
    Optional<Club> findByTitle(String url);
    List<Club> findAll();

    Club save(Club club);

    Club findClubById(Long id);

    void deleteById(Long clubId);
}
