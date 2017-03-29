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

    @Scheduled(fixedDelay = 86400000)
    @CrossOrigin
    @RequestMapping({"/admin/init"})
    public void initAll() {
        adminService.initAll();
    }
}
