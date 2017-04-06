package no.bouvet.sandvika.stabaek.repository;

import no.bouvet.sandvika.stabaek.domain.PlayerStatistics;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerStatisticsRepository extends CrudRepository<PlayerStatistics, String>{

    List<PlayerStatistics> findByPlayerId(String playerId);

    List<PlayerStatistics> findByStageId(String stageId);
}
