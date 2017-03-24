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
        return new Team(Integer.toString(nifsTeam.getId()), nifsTeam.getName());
    }

    public static List<Team> getTeams(List<NifsTeam> nifsTeam) {
        return nifsTeam.stream().map(NifsTeamTranslator::getTeam).collect(Collectors.toList());
    }
}
