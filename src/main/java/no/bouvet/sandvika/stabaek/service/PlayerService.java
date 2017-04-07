package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.domain.Team;
import no.bouvet.sandvika.stabaek.repository.PlayerRepository;
import no.bouvet.sandvika.stabaek.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService implements ClearableService{

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    public List<Player> getAllPlayers(){
        List<Player> players = new ArrayList<>();
        for (Player player : playerRepository.findAll())
            players.add(player);
        return players;
    }

    public void addPlayer(Player player) {
        this.playerRepository.save(player);
    }

    public Player getPlayer(String id) {
        return playerRepository.findOne(id);
    }

    public List<Player> getPlayersFromTeam(String id) {
        Team team = teamRepository.findOne(id);
        return team.getPlayers().stream().collect(Collectors.toList());
    }

    public void clearDb() {
        this.playerRepository.deleteAll();
    }
}
