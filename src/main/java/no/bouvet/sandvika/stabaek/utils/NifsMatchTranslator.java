package no.bouvet.sandvika.stabaek.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import no.bouvet.sandvika.stabaek.domain.Fixture;
import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.nifs.*;

public class NifsMatchTranslator {
    public NifsMatchTranslator() {
    }

    public static Fixture getFixture(NifsMatch nifsMatch) {
        try {
            String id = Integer.toString(nifsMatch.getId());
            String nonCompactHomeTeamId = nifsMatch.getHomeTeam() != null ? Integer.toString(nifsMatch.getHomeTeam().getId()) : null;
            String nonCompactAwayTeamId = nifsMatch.getAwayTeam() != null ? Integer.toString(nifsMatch.getAwayTeam().getId()) : null;
            String nonCompactStadiumId = nifsMatch.getStadium() != null ? Integer.toString(nifsMatch.getStadium().getId()) : null;

            Fixture fixture = new Fixture(id, nifsMatch.getTimestamp(), nonCompactHomeTeamId, nonCompactAwayTeamId, nonCompactStadiumId);

            NifsTeam homeTeam = nifsMatch.getHomeTeam();
            NifsTeam awayTeam = nifsMatch.getAwayTeam();

            if (nifsMatch.isLineupConfirmed() && homeTeam != null && awayTeam != null){
                fixture.setHomeStartXI(getStartXi(nifsMatch.getHomeTeam()));
                fixture.setAwayStartXI(getStartXi(nifsMatch.getAwayTeam()));
            }

            if(nifsMatch.getResult() != null){
                fixture.setHomeScore(getHomeScore(nifsMatch));
                fixture.setAwayScore(getAwayScore(nifsMatch));
            }

            if(homeTeam != null){
                fixture.getHomeTeam().setName(nifsMatch.getHomeTeam().getName());
            }

            if(awayTeam != null){
                fixture.getAwayTeam().setName(nifsMatch.getAwayTeam().getName());
            }

            return fixture;

        } catch (Exception e) {
            return null;
        }
    }

    private static int getHomeScore(NifsMatch nifsMatch) {
        NifsResult result = nifsMatch.getResult();
        return Math.max(result.getHomeScore90(), Math.max(result.getHomeScore120(), result.getHomeScorePenalties()));
    }

    private static int getAwayScore(NifsMatch nifsMatch) {
        NifsResult result = nifsMatch.getResult();
        return Math.max(result.getAwayScore90(), Math.max(result.getAwayScore120(), result.getAwayScorePenalties()));
    }

    private static List<Player> getStartXi(NifsTeam nifsTeam) {
        if(nifsTeam.getPlayers() == null) return null;
        return nifsTeam.getPlayers().stream()
                .filter(NifsPerson::isStartsMatch)
                .map(nifsPerson -> NifsPlayerTranslator.getPlayer(nifsPerson, nifsTeam))
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
