package com.alvinskylers.clubclash.repository;

import com.alvinskylers.clubclash.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByTitle(String url);

    List<Club> findAll();

    Club save(Club club);

    Club findClubById(Long id);

    void deleteById(Long clubId);

    @Query("SELECT c FROM Club c WHERE c.title LIKE CONCAT('%', :query, '%') ")
    List<Club> searchClubs(String query);
}
