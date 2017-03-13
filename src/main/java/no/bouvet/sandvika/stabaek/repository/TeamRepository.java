package no.bouvet.sandvika.stabaek.repository;

import no.bouvet.sandvika.stabaek.domain.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, String> {
}
