package no.bouvet.sandvika.stabaek.controller;

import no.bouvet.sandvika.stabaek.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    public AdminController() {
    }

    @CrossOrigin
    @RequestMapping({"/admin/init"})
    public void initAll() {
        adminService.initAll();
    }


    @CrossOrigin
    @RequestMapping({"/admin/updateTeams"})
    public void updateTeams() {
        adminService.updateTeams();
    }


    @CrossOrigin
    @RequestMapping({"/admin/updatePlayers"})
    public void updatePlayers() {
        adminService.updatePlayers();
    }


    @CrossOrigin
    @RequestMapping({"/admin/updateStageStatistics"})
    public void updateStageStatistics() {
        adminService.updateStageStatistics();
    }


    @CrossOrigin
    @RequestMapping({"/admin/updateStadiums"})
    public void updateStadiums() {
        adminService.updateStadiums();
    }


    @CrossOrigin
    @RequestMapping({"/admin/updateFixtures"})
    public void updateFixtures() {
        adminService.updateFixtures();
    }
}
