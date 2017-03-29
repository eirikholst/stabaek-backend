package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.Stadium;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NifsStadiumTranslator {
    public NifsStadiumTranslator() {
    }

    public static Stadium getStadium(NifsTeam nifsTeam) {
        try {
            String stadiumId = nifsTeam.getId() + "_s";
            String stadiumName = NifsTeamTranslator.getTeam(nifsTeam).getStadiumName();
            String teamId = Integer.toString(nifsTeam.getId());
            return new Stadium(stadiumId, stadiumName, teamId);
        }
        catch (Exception e){
            return null;
        }
    }

    public static List<Stadium> getStadiums(List<NifsTeam> nifsTeams) {
        return nifsTeams.stream()
                .map(NifsStadiumTranslator::getStadium)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
