package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.Stadium;
import no.bouvet.sandvika.stabaek.nifs.NifsStadium;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NifsStadiumTranslator {
    public NifsStadiumTranslator() {
    }

    public static Stadium getStadium(NifsTeam nifsTeam) {
        try {
            NifsStadium nifsStadium = getNifsStadium(nifsTeam);
            if(nifsStadium == null) return null;
            String stadiumImageUrl = nifsStadium.getImage() != null ? nifsStadium.getImage().getUrl() : null;
            return new Stadium(nifsStadium.getId(), nifsStadium.getName(), nifsTeam.getId(), stadiumImageUrl);
        }
        catch (Exception e){
            return null;
        }
    }

    public static Stadium getStadium(NifsStadium nifsStadium, int teamId){
        return new Stadium(nifsStadium.getId(), nifsStadium.getName(), teamId, nifsStadium.getImage().getUrl());
    }

    public static NifsStadium getNifsStadium(NifsTeam nifsTeam) {
        return nifsTeam.getStadiums().stream()
                .filter(nifsStadium -> nifsStadium.getDateTo() == null)
                .findFirst().orElse(null);
    }

    public static List<Stadium> getStadiums(List<NifsTeam> nifsTeams) {
        return nifsTeams.stream()
                .map(NifsStadiumTranslator::getStadium)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
