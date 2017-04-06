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

    public List<PlayerStatistics> getPlayerStatisticsByPlayer(String playerId){
        return playerStatisticsRepository.findByPlayerId(playerId);
    }

    public void addPlayerStatistics(PlayerStatistics playerStatistics){
        playerStatisticsRepository.save(playerStatistics);
    }

    public List<PlayerStatistics> getAllPlayerStatistics() {
        List<PlayerStatistics> playerStatistics = new ArrayList<>();
        playerStatisticsRepository.findAll().forEach(playerStatistics::add);
        return playerStatistics;
    }

    public List<PlayerStatistics> getPlayerStatisticsByStage(String stageId){
        return playerStatisticsRepository.findByStageId(stageId);
    }

    public List<PlayerStatistics> getPlayerStatisticsByPlayerAndStage(String playerId, String stageId){
        return playerStatisticsRepository.findByPlayerIdAndStageId(playerId, stageId);
    }

    public void clearDb() {
        this.playerStatisticsRepository.deleteAll();
    }
}
