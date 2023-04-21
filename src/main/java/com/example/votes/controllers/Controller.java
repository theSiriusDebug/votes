package com.example.votes.controllers;

import com.example.votes.models.Vote;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller {

    private final VoteRepository voteRepository;

    public Controller(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String showHomePage(Model model, @RequestParam(required = false) String button) {
        if (button != null && (button.equals("1") || button.equals("2"))) {
            voteRepository.save(new Vote(button));
        }
        long vote1Count = voteRepository.countByButton("1");
        long vote2Count = voteRepository.countByButton("2");
        model.addAttribute("vote1Count", vote1Count);
        model.addAttribute("vote2Count", vote2Count);
        return "index";
    }

    @GetMapping("/vote")
    public String vote(){
        return "vote";
    }
}
