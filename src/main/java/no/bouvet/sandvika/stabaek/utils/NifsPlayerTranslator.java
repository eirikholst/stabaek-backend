package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.domain.Transfer;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

import java.util.*;
import java.util.stream.Collectors;

public class NifsPlayerTranslator {

    public static Player getPlayer(NifsPerson nifsPerson, NifsTeam clubTeam) {
        String profilePictureUrl = nifsPerson.getProfilePicture() != null ? nifsPerson.getProfilePicture().getUrl() : null;
        int shirtNumber = Arrays.stream(nifsPerson.getTeams())
                .filter(nifsTeam -> nifsTeam.getId() == clubTeam.getId())
                .findFirst().orElse(clubTeam)
                .getShirtNumber();
        return new Player(
                Integer.toString(nifsPerson.getId()),
                nifsPerson.getFirstName(),
                nifsPerson.getLastName(),
                nifsPerson.getPosition().getPosition(),
                Integer.toString(clubTeam.getId()),
                shirtNumber,
                profilePictureUrl,
                NifsTransferTranslator.getTransfers(nifsPerson.getTransfers()),
                NifsStageStatisticsTranslator.getPlayerStatistics(nifsPerson));
    }
}
