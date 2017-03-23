package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerService  {

    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers(){
        List<Player> players = new ArrayList<>();
        for (Player player : playerRepository.findAll())
            players.add(player);
        return players;
    }

    public void addPlayer(Player player) {
        this.playerRepository.save(player);
    }
}
