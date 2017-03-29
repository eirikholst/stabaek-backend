package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.nifs.NifsMatch;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
class NifsService {

    private String eliteserienUrl = "https://api.nifs.no/countries/1/tournaments/5/stages/673879";
    private String nifsBaseUrl = "https://api.nifs.no";

    List<NifsTeam> getAllTeamsFromEliteserien(){
        RestTemplate restTemplate = new RestTemplate();
        NifsTeam[] compactTeamsInEliteserien = restTemplate.getForObject(eliteserienUrl + "/teams", NifsTeam[].class);
        return Arrays.stream(compactTeamsInEliteserien)
                .map(NifsTeam::getId)
                .map(this::getFullNifsTeam)
                .collect(Collectors.toList());
    }

    private NifsTeam getFullNifsTeam(int id) {
        RestTemplate restTemplate = new RestTemplate();
        String restUrl = "https://api.nifs.no/teams/" + id;
        return restTemplate.getForObject(restUrl, NifsTeam.class);
    }

    List<NifsMatch> getAllNifsMatchesFromEliteserien() {

        RestTemplate restTemplate = new RestTemplate();
        return Arrays.stream(restTemplate.getForObject(eliteserienUrl + "/matches", NifsMatch[].class))
                .map(NifsMatch::getId)
                .filter(Objects::nonNull)
                .map(matchId -> restTemplate.getForObject(nifsBaseUrl + "/matches/" + matchId, NifsMatch.class))
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    NifsPerson getPerson(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String urlParameters = "/?withStageStatistics=1&stripFriendlies=1&stripNationals=1";
        String restUrl = nifsBaseUrl + "/persons/" + id + urlParameters;
        return restTemplate.getForObject(restUrl, NifsPerson.class);
    }
}
