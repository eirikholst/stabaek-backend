package no.bouvet.sandvika.stabaek.controller;

import no.bouvet.sandvika.stabaek.domain.Table;
import no.bouvet.sandvika.stabaek.domain.team.TeamInTableModus;
import no.bouvet.sandvika.stabaek.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TableController {

    @Autowired
    private TableService tableService;

    @CrossOrigin(origins = "*")
    @RequestMapping({"/table"})
    public Table getTable() {
        return this.tableService.getTable();
    }

    @CrossOrigin(origins = "*")
    @RequestMapping({"/table/teams"})
    public List<TeamInTableModus> getTableTeams() {
        return this.tableService.getTable().getTeams();
    }

}
