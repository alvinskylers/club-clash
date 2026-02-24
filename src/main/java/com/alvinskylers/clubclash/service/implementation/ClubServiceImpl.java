package com.alvinskylers.clubclash.service.implementation;

import com.alvinskylers.clubclash.dto.ClubDTO;
import com.alvinskylers.clubclash.models.Club;
import com.alvinskylers.clubclash.repository.ClubRepository;
import com.alvinskylers.clubclash.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

   private ClubRepository clubRepository;

   @Autowired
   public ClubServiceImpl(ClubRepository clubRepository) {
       this.clubRepository = clubRepository;
   }


    @Override
    public List<ClubDTO> findAllClubs() {
       List<Club> clubs = clubRepository.findAll();
       return clubs.stream()
               .map(this::mapToClubDTO)
               .collect(Collectors.toList());
    }

    @Override
    public Club createClub(ClubDTO clubDTO) {
       Club club = mapToClub(clubDTO);
       return clubRepository.save(club);
    }

    @Override
    public ClubDTO findClubById(Long id) {
       Club club = clubRepository.findClubById(id);
       return mapToClubDTO(club);
    }

    @Override
    public void updateClub(ClubDTO clubDTO) {
        Club club = mapToClub(clubDTO);
    }

    private Club mapToClub(ClubDTO clubDTO) {
       return Club.builder()
               .id(clubDTO.getId())
               .title(clubDTO.getTitle())
               .description(clubDTO.getDescription())
               .photoURL(clubDTO.getPhotoURL())
               .createdOn(clubDTO.getCreatedOn())
               .editedOn(clubDTO.getEditedOn())
               .build();
    }

    private ClubDTO mapToClubDTO (Club club) {
      return ClubDTO.builder()
               .id(club.getId())
               .title(club.getTitle())
               .description(club.getDescription())
               .photoURL(club.getPhotoURL())
               .createdOn(club.getCreatedOn())
               .editedOn(club.getEditedOn())
               .build();
    }

}
