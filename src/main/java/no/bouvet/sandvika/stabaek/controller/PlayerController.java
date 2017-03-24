package no.bouvet.sandvika.stabaek.controller;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @CrossOrigin
    @RequestMapping("/players")
    public List<Player> getAllPlayers(){
        return playerService.getAllPlayers();
    }

    @CrossOrigin
    @RequestMapping("/players/{id}")
    public Player getPlayer(@PathVariable(name = "id") String id){
        return playerService.getPlayer(id);
    }

    @CrossOrigin
    @RequestMapping("/teams/{id}/players")
    public List<Player> getPlayersFromTeam(@PathVariable(name = "id") String id){
        return playerService.getPlayersFromTeam(id);
    }

    @CrossOrigin
    @RequestMapping("/teams/{teamId}/players/{playerId}")
    public Player getPlayerFromTeam(@PathVariable(name = "playerId") String id){
        return playerService.getPlayer(id);
    }
}
