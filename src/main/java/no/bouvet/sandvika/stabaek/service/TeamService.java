package no.bouvet.sandvika.stabaek.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import no.bouvet.sandvika.stabaek.domain.Team;
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

    public void addTeam(Team team) {
        this.teamRepository.save(team);
    }

    @Transactional
    public Team getTeam(String id) {
        return teamRepository.findOne(id);
    }

    public List<Team> getTeamByTeamName(String teamName) {
        return teamRepository.findByName(teamName);
    }

    public void clearDb() {
        this.teamRepository.deleteAll();
    }
}
