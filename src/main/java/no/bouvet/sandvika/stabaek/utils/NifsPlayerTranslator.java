package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class NifsPlayerTranslator {

    public static Player getPlayer(NifsPerson nifsPerson, List<String> teamIdsInEliteserien) {
        if (nifsPerson == null) return null;

        String position = nifsPerson.getPosition() != null ? nifsPerson.getPosition().getPosition() : "";

        NifsTeam clubTeam = getClubTeam(nifsPerson, teamIdsInEliteserien);
        if(clubTeam == null) return null;

        return new Player(nifsPerson.getUid(), nifsPerson.getFirstName(), nifsPerson.getLastName(), position, Integer.toString(clubTeam.getId()), clubTeam.getShirtNumber());
    }

    private static NifsTeam getClubTeam(NifsPerson nifsPerson, List<String> teamIdsInEliteserien) {
        NifsTeam[] teams = nifsPerson.getTeams();
        if(teams == null) return null;

        return Arrays.stream(teams)
                .filter(NifsTeam::isActive)
                .filter(Objects::nonNull)
                .filter(nifsTeam -> teamIdsInEliteserien.contains(Integer.toString(nifsTeam.getId())))
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }
}
