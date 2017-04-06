package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

import java.util.*;
import java.util.stream.Collectors;

public class NifsPlayerTranslator {

    static Player getPlayer(NifsPerson nifsPerson, NifsTeam clubTeam) {
        String profilePictureUrl = nifsPerson.getProfilePicture() != null ? nifsPerson.getProfilePicture().getUrl() : null;
        return new Player(
                Integer.toString(nifsPerson.getId()),
                nifsPerson.getFirstName(),
                nifsPerson.getLastName(),
                nifsPerson.getPosition().getPosition(),
                Integer.toString(clubTeam.getId()),
                clubTeam.getShirtNumber(),
                profilePictureUrl);
    }


    public static List<Player> getPlayers(NifsTeam nifsTeam) {
        return Arrays.stream(nifsTeam.getPlayers())
                .map(nifsPerson -> getPlayer(nifsPerson, nifsTeam))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
