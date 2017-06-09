package no.bouvet.sandvika.stabaek.controller;

import no.bouvet.sandvika.stabaek.domain.PlayerStatistics;
import no.bouvet.sandvika.stabaek.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerStatisticsController {

    @Autowired
    private PlayerService playerService;

    @CrossOrigin(origins = "*")
    @RequestMapping("/playerStatistics")
    public List<PlayerStatistics> getAllPlayerStatistics(
            @RequestParam(required = false, value = "playerId") String playerId,
            @RequestParam(required = false, value = "stageId") String stageId,
            @RequestParam(required = false, value = "hasValue") boolean hasValue
    ){
        return playerService.getPlayersStatistics(playerId, stageId, hasValue);
    }
}
