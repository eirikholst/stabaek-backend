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

        String clubTeamId = getClubTeamId(nifsPerson, teamIdsInEliteserien);
        if(clubTeamId == null) return null;

        return new Player(nifsPerson.getUid(), nifsPerson.getFirstName(), nifsPerson.getLastName(), position, clubTeamId);
    }

    private static String getClubTeamId(NifsPerson nifsPerson, List<String> teamIdsInEliteserien) {
        NifsTeam[] teams = nifsPerson.getTeams();
        if(teams == null) return null;

        return Arrays.stream(teams)
                .filter(NifsTeam::isActive)
                .map(NifsTeam::getId)
                .filter(Objects::nonNull)
                .map(teamIdSInt -> Integer.toString(teamIdSInt))
                .filter(teamIdsInEliteserien::contains)
                .filter(Objects::nonNull)
                .findFirst()
                .orElse(null);
    }
}
