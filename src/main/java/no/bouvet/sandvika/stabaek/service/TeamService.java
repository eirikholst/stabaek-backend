package no.bouvet.sandvika.stabaek.service;

import java.util.ArrayList;
import java.util.List;

import no.bouvet.sandvika.stabaek.domain.team.Team;
import no.bouvet.sandvika.stabaek.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamService implements ClearableService{
    @Autowired
    private TeamRepository teamRepository;

    public TeamService() {
    }

    @Transactional
    public List<Team> getAllTeams() {
        ArrayList teams = new ArrayList();
        this.teamRepository.findAll().forEach(teams::add);
        return teams;
    }

    @Transactional
    public void addTeam(Team team) {
        this.teamRepository.save(team);
    }

    @Transactional
    public Team getTeam(String id) {
        return teamRepository.findOne(id);
    }

    @Transactional
    public List<Team> getTeamByTeamName(String teamName) {
        return teamRepository.findByName(teamName);
    }

    @Transactional
    public void clearDb() {
        this.teamRepository.deleteAll();
    }
}
