package no.bouvet.sandvika.stabaek.controller;

import no.bouvet.sandvika.stabaek.nifs.NifsTeam;
import no.bouvet.sandvika.stabaek.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @RequestMapping({"/admin/initNifsTeams"})
    public void initNifsTeams() {
        adminService.initNifsTeams();
    }

    @CrossOrigin
    @RequestMapping({"/admin/nifsTeams"})
    public List<NifsTeam> getAllNifsTeams() {
        return adminService.getAllNifsTeams();
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
    @RequestMapping({"/admin/updateStadiums"})
    public void updateStadiums() {
        adminService.updateStadiums();
    }


    @CrossOrigin
    @RequestMapping({"/admin/updateFixtures"})
    public void updateFixtures() {
        adminService.updateFixtures();
    }


    @CrossOrigin
    @RequestMapping({"/admin/initTest"})
    public void initTest() {
        adminService.initTest();
    }
}
