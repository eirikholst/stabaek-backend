package no.bouvet.sandvika.stabaek.service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import no.bouvet.sandvika.stabaek.domain.Stadium;
import no.bouvet.sandvika.stabaek.repository.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StadiumService implements ClearableService{
    @Autowired
    private StadiumRepository stadiumRepository;

    public StadiumService() {
    }

    public List<Stadium> getAllStadiums() {
        ArrayList stadiums = new ArrayList();
        this.stadiumRepository.findAll().forEach(stadiums::add);
        return stadiums;
    }

    public void addStadium(Stadium stadium) {
        this.stadiumRepository.save(stadium);
    }

    public Stadium getStadium(String id) {
        return this.stadiumRepository.findOne(id);
    }

    public void clearDb() {
        this.stadiumRepository.deleteAll();
    }
}
