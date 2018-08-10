package no.bouvet.sandvika.stabaek.repository;

import java.util.List;
import no.bouvet.sandvika.stabaek.domain.Fixture;
import org.springframework.data.repository.CrudRepository;

public interface FixtureRepository extends CrudRepository<Fixture, Integer> {
    List<Fixture> findByHomeTeamName(String var1);

    List<Fixture> findByAwayTeamName(String var1);

    List<Fixture> findByStadiumName(String var1);
}
