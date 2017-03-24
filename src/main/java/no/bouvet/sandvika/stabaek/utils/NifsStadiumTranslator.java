package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.Stadium;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

import java.util.List;
import java.util.stream.Collectors;

public class NifsStadiumTranslator {
    public NifsStadiumTranslator() {
    }

    public static Stadium getStadium(NifsTeam nifsTeam) {
        String stadiumId = NifsIdUtils.getStadiumIdFromHomeTeamUid(nifsTeam.getUid());
        String stadiumName = NifsTeamTranslator.getTeam(nifsTeam).getStadiumName();
        String teamId = NifsIdUtils.getNonCompactIid(nifsTeam.getUid());
        return new Stadium(stadiumId, stadiumName, teamId);
    }

    public static List<Stadium> getStadiums(List<NifsTeam> nifsTeams) {
        return nifsTeams.stream().map(nifsTeam -> getStadium(nifsTeam)).collect(Collectors.toList());
    }
}
