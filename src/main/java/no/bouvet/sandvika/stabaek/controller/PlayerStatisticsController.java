package no.bouvet.sandvika.stabaek.controller;

import no.bouvet.sandvika.stabaek.domain.PlayerStatistics;
import no.bouvet.sandvika.stabaek.service.PlayerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerStatisticsController {

    @Autowired
    private PlayerStatisticsService playerStatisticsService;

    @CrossOrigin
    @RequestMapping({"/playerStatistics"})
    public List<PlayerStatistics> getAllPlayerStatistics(
            @RequestParam(required = false) String playerId,
            @RequestParam(required = false) String stageId
    ){
        return playerStatisticsService.getPlayerStatistics(playerId, stageId);
    }
}
