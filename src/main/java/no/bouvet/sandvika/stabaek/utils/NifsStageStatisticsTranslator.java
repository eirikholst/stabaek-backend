package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.PlayerStatistics;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsStage;
import no.bouvet.sandvika.stabaek.nifs.NifsStageStatistics;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

import java.util.List;
import java.util.stream.Collectors;

public class NifsStageStatisticsTranslator {

    public static PlayerStatistics getPlayerStatistics(NifsStageStatistics nifsStageStatistics, NifsPerson nifsPerson) {
        NifsStage nifsStage = nifsStageStatistics.getStage();
        NifsTeam nifsTeam = nifsStageStatistics.getTeam();
        String playerName = nifsPerson.getFirstName() + " " + nifsPerson.getLastName();
        if(nifsStage == null || nifsTeam == null) return null;
        return new PlayerStatistics(
                nifsPerson.getId(),
                playerName,
                nifsStage.getFullName(),
                Integer.toString(nifsStage.getId()),
                nifsTeam.getName(),
                Integer.toString(nifsTeam.getId()),
                nifsStageStatistics.getGoals(),
                nifsStageStatistics.getAssists(),
                nifsStageStatistics.getRedCards(),
                nifsStageStatistics.getYellowCards()
        );
    }

    public static List<PlayerStatistics> getPlayerStatistics(NifsPerson nifsPerson) {
        if(nifsPerson == null || nifsPerson.getStageStatistics() == null) return null;
        return nifsPerson.getStageStatistics().stream()
                .map(nifsStageStatistics -> getPlayerStatistics(nifsStageStatistics, nifsPerson))
                .collect(Collectors.toList());
    }
}
