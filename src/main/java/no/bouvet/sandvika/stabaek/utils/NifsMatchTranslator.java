package no.bouvet.sandvika.stabaek.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import no.bouvet.sandvika.stabaek.domain.Fixture;
import no.bouvet.sandvika.stabaek.nifs.NifsMatch;
import no.bouvet.sandvika.stabaek.utils.NifsUidUtils;

public class NifsMatchTranslator {
    public NifsMatchTranslator() {
    }

    public static Fixture getFixture(NifsMatch nifsMatch) {
        String nonCompactHomeTeamId = NifsUidUtils.getNonCompactUid(nifsMatch.getHomeTeam().getUid());
        String nonCompactAwayTeamId = NifsUidUtils.getNonCompactUid(nifsMatch.getAwayTeam().getUid());
        String nonCompactStadiumId = NifsUidUtils.getStadiumUidFromHomeTeamUid(nifsMatch.getHomeTeam().getUid());
        return new Fixture(nifsMatch.getUid(), nifsMatch.getTimestamp(), nonCompactHomeTeamId, nonCompactAwayTeamId, nonCompactStadiumId);
    }

    public static List<Fixture> getFixtures(NifsMatch[] nifsMatches) {
        return (List)Arrays.stream(nifsMatches).map((m) -> {
            return getFixture(m);
        }).collect(Collectors.toList());
    }
}
