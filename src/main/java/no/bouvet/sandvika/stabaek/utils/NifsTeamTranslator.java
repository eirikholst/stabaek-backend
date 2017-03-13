package no.bouvet.sandvika.stabaek.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import no.bouvet.sandvika.stabaek.domain.Team;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

public class NifsTeamTranslator {
    public NifsTeamTranslator() {
    }

    public static Team getTeam(NifsTeam nifsTeam) {
        return new Team(nifsTeam.getUid(), nifsTeam.getName());
    }

    public static List<Team> getTeams(NifsTeam[] nifsTeam) {
        return (List)Arrays.stream(nifsTeam).map((t) -> {
            return getTeam(t);
        }).collect(Collectors.toList());
    }
}
