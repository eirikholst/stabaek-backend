package no.bouvet.sandvika.stabaek.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import no.bouvet.sandvika.stabaek.domain.Fixture;
import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.nifs.NifsMatch;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

public class NifsMatchTranslator {
    public NifsMatchTranslator() {
    }

    private static Fixture getFixture(NifsMatch nifsMatch) {
        try {
            String nonCompactHomeTeamId = Integer.toString(nifsMatch.getHomeTeam().getId());
            String nonCompactAwayTeamId = Integer.toString(nifsMatch.getAwayTeam().getId());
            String nonCompactStadiumId = nifsMatch.getHomeTeam().getId() + "_s";
            if (!nifsMatch.isLineupConfirmed() || nifsMatch.getHomeTeam() == null || nifsMatch.getAwayTeam() == null)
                return new Fixture(nifsMatch.getUid(), nifsMatch.getTimestamp(), nonCompactHomeTeamId, nonCompactAwayTeamId, nonCompactStadiumId);
            return new Fixture(nifsMatch.getUid(), nifsMatch.getTimestamp(), nonCompactHomeTeamId, nonCompactAwayTeamId, nonCompactStadiumId, getStartXi(nifsMatch.getHomeTeam()), getStartXi(nifsMatch.getAwayTeam()));
        } catch (Exception e) {
            return null;
        }
    }

    private static List<Player> getStartXi(NifsTeam nifsTeam) {
        return Arrays.stream(nifsTeam.getPlayers())
                .filter(NifsPerson::isStartsMatch)
                .map(nifsPerson -> NifsPlayerTranslator.getPlayer(nifsPerson, nifsTeam.getId()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public static List<Fixture> getFixtures(List<NifsMatch> nifsMatches) {
        return nifsMatches.stream()
                .map(NifsMatchTranslator::getFixture)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
