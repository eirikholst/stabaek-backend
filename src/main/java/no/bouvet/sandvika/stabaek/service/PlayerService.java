package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.domain.PlayerStatistics;
import no.bouvet.sandvika.stabaek.domain.team.Team;
import no.bouvet.sandvika.stabaek.repository.PlayerRepository;
import no.bouvet.sandvika.stabaek.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService implements ClearableService{

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Transactional
    public List<Player> getAllPlayers(){
        List<Player> players = new ArrayList<>();
        for (Player player : playerRepository.findAll())
            players.add(player);
        return players;
    }

    @Transactional
    public void addPlayer(Player player) {
        this.playerRepository.save(player);
    }

    @Transactional
    public Player getPlayer(String id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Transactional
    public List<Player> getPlayersFromTeam(String id) {
        Team team = teamRepository.findById(id).orElse(null);
        return new ArrayList<>(team != null ? team.getPlayers() : new ArrayList<>());
    }

    @Transactional
    public void clearDb() {
        this.playerRepository.deleteAll();
    }

    @Transactional
    public List<PlayerStatistics> getPlayersStatistics(String playerId, String stageId, boolean omitZeros) {
        return getAllPlayers().stream()
                .filter(player -> playerId == null || player.getId().equals(playerId))
                .map(Player::getPlayerStatistics)
                .flatMap(Collection::stream)
                .filter(playerStatistics -> stageId == null || playerStatistics.getStageId().equals(stageId))
                .filter(playerStatistics -> !omitZeros || playerStatistics.hasValue())
                .collect(Collectors.toList());
    }
}
