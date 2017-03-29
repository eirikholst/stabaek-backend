package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.PlayerStatistics;
import no.bouvet.sandvika.stabaek.nifs.NifsStage;
import no.bouvet.sandvika.stabaek.nifs.NifsStageStatistics;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

public class NifsStageStatisticsTranslator {

    public static PlayerStatistics getPlayerStatistics(NifsStageStatistics nifsStageStatistics, String playerId) {
        NifsStage nifsStage = nifsStageStatistics.getStage();
        NifsTeam nifsTeam = nifsStageStatistics.getTeam();
        if(nifsStage == null || nifsTeam == null) return null;
        return new PlayerStatistics(
                "ssfp_" + playerId + "_" + nifsStage.getId(),
                playerId,
                nifsStage.getFullName(),
                Integer.toString(nifsStage.getId()),
                nifsStage.getName(),
                Integer.toString(nifsTeam.getId()),
                nifsStageStatistics.getGoals(),
                nifsStageStatistics.getAssists(),
                nifsStageStatistics.getRedCards(),
                nifsStageStatistics.getYellowCards()
        );
    }
}
