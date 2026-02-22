package com.alvinskylers.clubclash.repository;

import com.alvinskylers.clubclash.models.Club;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ClubRepository extends Repository<Club, Long> {
    Optional<Club> findByTitle(String url);
}
