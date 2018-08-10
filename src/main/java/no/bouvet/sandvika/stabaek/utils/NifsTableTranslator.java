package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.Table;
import no.bouvet.sandvika.stabaek.domain.team.Team;
import no.bouvet.sandvika.stabaek.domain.team.TeamInTableModus;
import no.bouvet.sandvika.stabaek.nifs.NifsTable;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NifsTableTranslator {

    public static Table getTable(NifsTable nifsTable){
        if(nifsTable == null) return null;
        List<TeamInTableModus> teams = Arrays.stream(nifsTable.getTeams())
                .map(NifsTeamTranslator::getTeamInTableModus)
                .collect(Collectors.toList());
        return new Table(nifsTable.getId(), teams);
    }

}
