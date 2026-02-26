package com.alvinskylers.clubclash.controller;

import com.alvinskylers.clubclash.dto.ClubDTO;
import com.alvinskylers.clubclash.models.Club;
import com.alvinskylers.clubclash.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@Controller
public class ClubController {

    private ClubService clubService;

    @Autowired
    public ClubController (ClubService clubService){
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String getClubs(Model model){
        List<ClubDTO> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/clubs/{clubId}")
    public String getClubDetails(@PathVariable("clubId") Long clubId, Model model) {
        ClubDTO clubDTO = clubService.findClubById(clubId);
        model.addAttribute("club", clubDTO);
        return "clubs-details";
    }

    @GetMapping("/clubs/new")
    public String getNewClub(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long clubId) {
        clubService.delete(clubId);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query")String query, Model model) {
        List<ClubDTO> clubs = clubService.searchClubs(query);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @PostMapping("/clubs/new")
    public String createNewClub(
            @Valid @ModelAttribute("club") ClubDTO clubDTO,
            BindingResult result,
            Model model
    ) {
        if (result.hasErrors()) {
            model.addAttribute("club", clubDTO);
            return "clubs-create";
        }

        clubService.createClub(clubDTO);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/edit")
    public String editClub(@PathVariable("clubId") Long clubId, Model model) {
        ClubDTO club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(
            @PathVariable("clubId") Long clubId,
            @Valid @ModelAttribute("club") ClubDTO clubDTO,
            BindingResult result
    ) {
        if (result.hasErrors()) {
            return "clubs-edit";
        }
        clubDTO.setId(clubId);
        clubService.updateClub(clubDTO);
        return "redirect:/clubs";
    }
}
