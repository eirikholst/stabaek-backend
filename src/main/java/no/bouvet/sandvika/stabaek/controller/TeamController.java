package no.bouvet.sandvika.stabaek.controller;

import java.util.List;
import no.bouvet.sandvika.stabaek.domain.team.Team;
import no.bouvet.sandvika.stabaek.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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

    @CrossOrigin
    @RequestMapping({"/teams/{id}"})
    public Team getTeam(@PathVariable("id") String id) {
        return this.teamService.getTeam(id);
    }

    @CrossOrigin
    @RequestMapping("/teams/name={teamName}")
    public List<Team> getTeamByName(@PathVariable("teamName") String teamName){
        return this.teamService.getTeamByTeamName(teamName);
    }
}
