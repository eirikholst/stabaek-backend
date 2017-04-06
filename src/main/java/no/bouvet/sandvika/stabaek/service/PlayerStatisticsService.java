package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.PlayerStatistics;
import no.bouvet.sandvika.stabaek.repository.PlayerStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerStatisticsService implements ClearableService{

    @Autowired
    private PlayerStatisticsRepository playerStatisticsRepository;


    public List<PlayerStatistics> getPlayerStatistics(String playerId, String stageId, String teamId) {
        return getAllPlayerStatistics().stream()
                .filter(playerStatistics -> playerId == null || playerStatistics.getPlayer().getId().equals(playerId))
                .filter(playerStatistics -> stageId == null || playerStatistics.getStageId().equals(stageId))
                .filter(playerStatistics -> teamId == null || playerStatistics.getTeamId().equals(teamId))
                .collect(Collectors.toList());
    }

    public void clearDb() {
        this.playerStatisticsRepository.deleteAll();
    }

    void addPlayerStatistics(PlayerStatistics playerStatistics){
        playerStatisticsRepository.save(playerStatistics);
    }

    private List<PlayerStatistics> getAllPlayerStatistics() {
        List<PlayerStatistics> playerStatistics = new ArrayList<>();
        playerStatisticsRepository.findAll().forEach(playerStatistics::add);
        return playerStatistics;
    }
}
