package no.bouvet.sandvika.stabaek.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import no.bouvet.sandvika.stabaek.domain.Team;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

public class NifsTeamTranslator {
    public NifsTeamTranslator() {
    }

    public static Team getTeam(NifsTeam nifsTeam) {
        String[] playerIds = new String[nifsTeam.getPlayers().length];
        for (int i = 0; i < nifsTeam.getPlayers().length; i++)
            playerIds[i] = Integer.toString(nifsTeam.getPlayers()[i].getId());

        return new Team(nifsTeam.getUid(), nifsTeam.getName());
    }

    public static List<Team> getTeams(NifsTeam[] nifsTeam) {
        return Arrays.stream(nifsTeam).map((t) -> getTeam(t)).collect(Collectors.toList());
    }
}
