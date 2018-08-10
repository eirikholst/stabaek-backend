package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.Fixture;
import no.bouvet.sandvika.stabaek.domain.HeadToHead;
import no.bouvet.sandvika.stabaek.domain.team.Team;
import no.bouvet.sandvika.stabaek.nifs.NifsHeadToHead;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NifsHeadToHeadTranslator {

    public static HeadToHead getHeadToHead(NifsHeadToHead nifsHeadToHead){
        if(nifsHeadToHead == null)
            return null;

        List<Team> teams = Arrays.stream(nifsHeadToHead.getTeams())
                .map(NifsTeamTranslator::getTeamInHeadToHeadModus)
                .collect(Collectors.toList());

        List<Fixture> previousFixtures = nifsHeadToHead.getPreviousMatches() != null
                ? getPreviousFixtures(nifsHeadToHead)
                : null;

        List<Fixture> previousFixturesFormOtherTournaments = nifsHeadToHead.getPreviousMatchesOtherTournaments() != null
                ? getPreviousFixturesFromOtherTournaments(nifsHeadToHead)
                : null;

        return new HeadToHead(nifsHeadToHead.getId(), teams, previousFixtures, previousFixturesFormOtherTournaments);
    }

    private static List<Fixture> getPreviousFixtures(NifsHeadToHead nifsHeadToHead) {
        return Arrays.stream(nifsHeadToHead.getPreviousMatches())
                .map(NifsMatchTranslator::getFixture)
                .collect(Collectors.toList());
    }


    private static List<Fixture> getPreviousFixturesFromOtherTournaments(NifsHeadToHead nifsHeadToHead) {
        return Arrays.stream(nifsHeadToHead.getPreviousMatchesOtherTournaments())
                .map(NifsMatchTranslator::getFixture)
                .collect(Collectors.toList());
    }
}
