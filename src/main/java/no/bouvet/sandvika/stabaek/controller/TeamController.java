package no.bouvet.sandvika.stabaek.controller;

import java.util.List;
import no.bouvet.sandvika.stabaek.domain.Team;
import no.bouvet.sandvika.stabaek.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    public TeamController() {
    }

    @CrossOrigin
    @RequestMapping({"/teams"})
    public List<Team> getAllTeams() {
        return this.teamService.getAllTeams();
    }
}
