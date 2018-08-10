package no.bouvet.sandvika.stabaek.utils;

import java.util.List;
import java.util.stream.Collectors;
import no.bouvet.sandvika.stabaek.domain.team.Team;
import no.bouvet.sandvika.stabaek.domain.team.TeamInHeadToHeadModus;
import no.bouvet.sandvika.stabaek.domain.team.TeamInTableModus;
import no.bouvet.sandvika.stabaek.nifs.NifsImage;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

public class NifsTeamTranslator {
    public NifsTeamTranslator() {
    }

    public static Team getTeam(NifsTeam nifsTeam) {
        NifsImage teamLogo = nifsTeam.getLogo();
        String teamLogoUrl = teamLogo != null ? teamLogo.getUrl() : "";
        return new Team(nifsTeam.getId(), nifsTeam.getName(), teamLogoUrl);
    }

    public static List<Team> getTeams(List<NifsTeam> nifsTeam) {
        return nifsTeam.stream().map(NifsTeamTranslator::getTeam).collect(Collectors.toList());
    }

    public static TeamInHeadToHeadModus getTeamInHeadToHeadModus(NifsTeam nifsTeam) {
        return new TeamInHeadToHeadModus(
                nifsTeam.getId(),
                nifsTeam.getName(),
                nifsTeam.getUrl(),
                nifsTeam.getWonHome(),
                nifsTeam.getDrawnHome(),
                nifsTeam.getLostHome(),
                nifsTeam.getGoalsForHome(),
                nifsTeam.getGoalsAgainstHome(),
                nifsTeam.getWonAway(),
                nifsTeam.getDrawnAway(),
                nifsTeam.getLostAway(),
                nifsTeam.getGoalsForAway(),
                nifsTeam.getGoalsAgainstAway(),
                nifsTeam.getWonHomeForm(),
                nifsTeam.getDrawnHomeForm(),
                nifsTeam.getLostHomeForm(),
                nifsTeam.getGoalsForHomeForm(),
                nifsTeam.getGoalsAgainstHomeFor(),
                nifsTeam.getWonAwayForm(),
                nifsTeam.getDrawnAwayForm(),
                nifsTeam.getLostAwayForm(),
                nifsTeam.getGoalsForAwayForm(),
                nifsTeam.getGoalsAgainstAwayForm()
        );
    }

    public static TeamInTableModus getTeamInTableModus(NifsTeam nifsTeam) {
        return new TeamInTableModus(
                nifsTeam.getId(),
                nifsTeam.getName(),
                nifsTeam.getUrl(),
                nifsTeam.getPlace(),
                nifsTeam.getPlayed(),
                nifsTeam.getWon(),
                nifsTeam.getDraw(),
                nifsTeam.getLost(),
                nifsTeam.getGoalsScored(),
                nifsTeam.getGoalsConceded(),
                nifsTeam.getGoalDifference(),
                nifsTeam.getPoints(),
                nifsTeam.getLastSixMatches(),
                nifsTeam.getChangeSinceLastRound(),
                nifsTeam.getLastSixMatches()
        );
    }
}
