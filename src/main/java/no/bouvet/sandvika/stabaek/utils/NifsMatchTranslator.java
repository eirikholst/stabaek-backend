package no.bouvet.sandvika.stabaek.utils;

import java.util.List;
import java.util.stream.Collectors;
import no.bouvet.sandvika.stabaek.domain.Fixture;
import no.bouvet.sandvika.stabaek.nifs.NifsMatch;

public class NifsMatchTranslator {
    public NifsMatchTranslator() {
    }

    public static Fixture getFixture(NifsMatch nifsMatch) {
        String nonCompactHomeTeamId = NifsIdUtils.getNonCompactIid(nifsMatch.getHomeTeam().getUid());
        String nonCompactAwayTeamId = NifsIdUtils.getNonCompactIid(nifsMatch.getAwayTeam().getUid());
        String nonCompactStadiumId = NifsIdUtils.getStadiumIdFromHomeTeamUid(nifsMatch.getHomeTeam().getUid());
        return new Fixture(nifsMatch.getUid(), nifsMatch.getTimestamp(), nonCompactHomeTeamId, nonCompactAwayTeamId, nonCompactStadiumId);
    }

    public static List<Fixture> getFixtures(List<NifsMatch> nifsMatches) {
        return nifsMatches.stream()
                .map(NifsMatchTranslator::getFixture)
                .collect(Collectors.toList());
    }
}
