package no.bouvet.sandvika.stabaek.repository;

import no.bouvet.sandvika.stabaek.domain.PlayerStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerStatisticsRepository extends CrudRepository<PlayerStatistics, String>{

    List<PlayerStatistics> findByPlayerId(String playerId);

    List<PlayerStatistics> findByStageId(String stageId);
}
