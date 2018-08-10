package no.bouvet.sandvika.stabaek.repository;

import no.bouvet.sandvika.stabaek.domain.team.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Integer> {
    List<Team> findByName(String teamName);
}
