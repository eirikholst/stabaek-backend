package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.nifs.NifsMatch;
import no.bouvet.sandvika.stabaek.nifs.NifsPerson;
import no.bouvet.sandvika.stabaek.nifs.NifsTeam;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NifsService {

    private String eliteserienUrl = "https://api.nifs.no/countries/1/tournaments/5/stages/673879";

    public List<NifsTeam> getAllTeamsFromEliteserien(){
        RestTemplate restTemplate = new RestTemplate();
        NifsTeam[] compactTeamsInEliteserien = restTemplate.getForObject(eliteserienUrl + "/teams", NifsTeam[].class, new Object[0]);
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

    public List<NifsMatch> getAllNifsMatchesFromEliteserien() {

        RestTemplate restTemplate = new RestTemplate();
        NifsMatch[] nifsMatches = restTemplate.getForObject(eliteserienUrl + "/matches", NifsMatch[].class, new Object[0]);
        return Arrays.stream(nifsMatches).collect(Collectors.toList());
    }

    public  NifsPerson getPerson(String id) {
        RestTemplate restTemplate = new RestTemplate();
        String restUrl = "https://api.nifs.no/persons/" + id;
        return restTemplate.getForObject(restUrl, NifsPerson.class);
    }
}
