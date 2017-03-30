package no.bouvet.sandvika.stabaek.controller;

import java.util.List;
import no.bouvet.sandvika.stabaek.domain.Stadium;
import no.bouvet.sandvika.stabaek.service.StadiumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StadiumController {
    @Autowired
    private StadiumService stadiumService;

    public StadiumController() {
    }

    @CrossOrigin
    @RequestMapping({"/stadiums"})
    public List<Stadium> getAllStadiums() {
        return this.stadiumService.getAllStadiums();
    }

    @CrossOrigin
    @RequestMapping({"/stadiums/{id}"})
    public Stadium getAllStadiums(@PathVariable("id") String id) {
        return this.stadiumService.getStadium(id);
    }
}
