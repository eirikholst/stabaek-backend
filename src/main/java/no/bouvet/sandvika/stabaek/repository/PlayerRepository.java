package no.bouvet.sandvika.stabaek.repository;

import no.bouvet.sandvika.stabaek.domain.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Integer>{
}
