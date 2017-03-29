package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.Player;
import no.bouvet.sandvika.stabaek.domain.PlayerStatistics;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;

import java.util.*;
import java.util.stream.Collectors;

public class NifsPlayerTranslator {

    static Player getPlayer(NifsPerson nifsPerson, int teamId){
        NifsTeam clubTeam = getClubTeam(nifsPerson, Integer.toString(teamId));
        return clubTeam == null ? null : getPlayer(nifsPerson, clubTeam);
    }

    public static Player getPlayerWithClubTeamInEliteserien(NifsPerson nifsPerson, List<String> teamIdsInEliteserien) {
        if (nifsPerson == null) return null;
        NifsTeam clubTeam = getClubTeam(nifsPerson, teamIdsInEliteserien);
        return clubTeam == null ? null : getPlayer(nifsPerson, clubTeam);

    }

    private static Player getPlayer(NifsPerson nifsPerson, NifsTeam clubTeam) {
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

    private static List<PlayerStatistics> getPlayerStatistics(NifsPerson nifsPerson) {
        if(nifsPerson.getStageStatistics() == null) return new ArrayList<>();
        return Arrays.stream(nifsPerson.getStageStatistics())
                .filter(Objects::nonNull)
                .map(nifsStageStatistics -> NifsStageStatisticsTranslator.getPlayerStatistics(nifsStageStatistics, Integer.toString(nifsPerson.getId())))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private static NifsTeam getClubTeam(NifsPerson nifsPerson, String teamId) {
        return getClubTeam(nifsPerson, Collections.singletonList(teamId));
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
