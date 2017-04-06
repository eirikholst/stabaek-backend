package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.PlayerStatistics;
import no.bouvet.sandvika.stabaek.repository.PlayerStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlayerStatisticsService implements ClearableService{

    @Autowired
    private PlayerStatisticsRepository playerStatisticsRepository;


    public List<PlayerStatistics> getPlayerStatistics(String playerId, String stageId) {
        if(playerId == null && stageId == null)
            return getAllPlayerStatistics();
        if(playerId != null && stageId != null)
            return getPlayerStatisticsByPlayerAndStage(playerId, stageId);
        if(playerId != null)
            return getPlayerStatisticsByPlayer(playerId);
        return getPlayerStatisticsByStage(stageId);
    }

    public void clearDb() {
        this.playerStatisticsRepository.deleteAll();
    }

    private List<PlayerStatistics> getPlayerStatisticsByPlayer(String playerId){
        return playerStatisticsRepository.findByPlayerId(playerId);
    }

    void addPlayerStatistics(PlayerStatistics playerStatistics){
        playerStatisticsRepository.save(playerStatistics);
    }

    private List<PlayerStatistics> getAllPlayerStatistics() {
        List<PlayerStatistics> playerStatistics = new ArrayList<>();
        playerStatisticsRepository.findAll().forEach(playerStatistics::add);
        return playerStatistics;
    }

    private List<PlayerStatistics> getPlayerStatisticsByStage(String stageId){
        return playerStatisticsRepository.findByStageId(stageId);
    }

    private List<PlayerStatistics> getPlayerStatisticsByPlayerAndStage(String playerId, String stageId){
        return playerStatisticsRepository.findByPlayerIdAndStageId(playerId, stageId);
    }

}
