package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NifsPlayerTranslator {

    public static List<Player> getPlayers(NifsTeam nifsTeam){
        List<Player> players = new ArrayList<>();
        for (NifsPerson nifsPerson : nifsTeam.getPlayers())
            players.add(getPlayer(nifsPerson));
        return players;
    }

    public static Player getPlayer(NifsPerson nifsPerson) {
        if(nifsPerson == null) return null;
        String position = nifsPerson.getPosition() != null ? nifsPerson.getPosition().getPosition() : "";
        String teamId = (nifsPerson.getTeams().length > 0 && nifsPerson.getTeams()[0] != null) ? Integer.toString(nifsPerson.getTeams()[0].getId()) : "";
        return new Player(nifsPerson.getUid(), nifsPerson.getFirstName(), nifsPerson.getLastName(), position, teamId);
    }

    public static List<Player> getPlayers(NifsTeam[] nifsTeams) {
        return Arrays.stream(nifsTeams)
                .map(NifsPlayerTranslator::getPlayers)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
