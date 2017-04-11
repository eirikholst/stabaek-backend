package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.nifs.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class NifsService {

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
                .map(this::getNifsMatch)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public NifsMatch getNifsMatch(Integer matchId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(nifsBaseUrl + "/matches/" + matchId, NifsMatch.class);
    }

    NifsPerson getPerson(int id) {
        return this.getPerson(Integer.toString(id));
    }

    NifsPerson getPerson(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String urlParameters = "/?withStageStatistics=1&stripFriendlies=1&stripNationals=1";
        String restUrl = nifsBaseUrl + "/persons/" + id + urlParameters;
        return restTemplate.getForObject(restUrl, NifsPerson.class);
    }

    public NifsStadium getStadium(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String restUrl = nifsBaseUrl + "/stadiums/" + id;
        return restTemplate.getForObject(restUrl, NifsStadium.class);
    }

    public NifsTeam getNifsTeam(int id) {
        return getFullNifsTeam(id);
    }

    public NifsHeadToHead getHeadToHead(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String restUrl = nifsBaseUrl + "/matches/" + id + "/headToHead";
        return restTemplate.getForObject(restUrl, NifsHeadToHead.class);
    }

    public NifsTable getNifsTable(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(eliteserienUrl + "/table", NifsTable.class);
    }
}
