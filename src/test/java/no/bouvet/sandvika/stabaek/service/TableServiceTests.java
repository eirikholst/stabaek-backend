package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.Table;
import no.bouvet.sandvika.stabaek.domain.team.TeamInTableModus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TableServiceTests {

    @Autowired
    private TableService tableService;
    private Table testTable;
    private TeamInTableModus testTeam;

    @Before
    public void testInit(){
        testTable = tableService.getTable();
        testTeam = testTable.getTeams().get(0);
    }

    @Test
    public void talbeIsNotNull(){
        Table table = tableService.getTable();
        assertThat(table).isNotNull();
    }

    @Test
    public void teamInTableModusIsNotNull(){
        TeamInTableModus testTeam = tableService.getTable().getTeams().get(0);
        assertThat(testTeam).isNotNull();
    }
}
