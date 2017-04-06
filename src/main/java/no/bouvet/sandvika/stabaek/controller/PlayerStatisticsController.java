package no.bouvet.sandvika.stabaek.controller;

import no.bouvet.sandvika.stabaek.domain.PlayerStatistics;
import no.bouvet.sandvika.stabaek.service.PlayerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerStatisticsController {

    @Autowired
    private PlayerStatisticsService playerStatisticsService;

    @CrossOrigin
    @RequestMapping({"/playerStatistics"})
    public List<PlayerStatistics> getAllPlayerStatistics(){
        return playerStatisticsService.getAllPlayerStatistics();
    }

    @CrossOrigin
    @RequestMapping({"/playerStatistics/byPlayer={playerId}"})
    public List<PlayerStatistics> getPlayerStatisticsByPlayer(@PathVariable(name = "playerId") String playerId){
        return playerStatisticsService.getPlayerStatisticsByPlayer(playerId);
    }

    @CrossOrigin
    @RequestMapping({"/playerStatistics/byStage={stageId}"})
    public List<PlayerStatistics> getPlayerStatisticsByStage(@PathVariable(name = "stageId") String stageId){
        return playerStatisticsService.getPlayerStatisticsByStage(stageId);
    }

    @CrossOrigin
    @RequestMapping({"/playerStatistics/byPlayer={playerId}byStage={stageId}"})
    public List<PlayerStatistics> getPlayerStatisticsByPlayerAndStage(@PathVariable(name = "playerId") String playerId,
                                                                      @PathVariable(name = "stageId") String stageId){
        return playerStatisticsService.getPlayerStatisticsByPlayerAndStage(playerId, stageId);
    }
}
