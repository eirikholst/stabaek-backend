package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.nifs.NifsTeam;
import no.bouvet.sandvika.stabaek.repository.NifsTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NifsTeamService implements ClearableService{

    @Autowired
    private NifsTeamRepository nifsTeamRepository;

    public List<NifsTeam> getAllNifsTeams(){
        List<NifsTeam> nifsTeams = new ArrayList<>();
        nifsTeamRepository.findAll().forEach(nifsTeams::add);
        return nifsTeams;
    }

    public void addTeam(NifsTeam nifsTeam){
        nifsTeamRepository.save(nifsTeam);
    }

    public void clearDb(){
        nifsTeamRepository.deleteAll();
    }
}
