package no.bouvet.sandvika.stabaek.repository;

import no.bouvet.sandvika.stabaek.nifs.NifsTeam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NifsTeamRepository extends CrudRepository<NifsTeam, Integer> {

    NifsTeam findById(int id);

}
