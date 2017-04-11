package no.bouvet.sandvika.stabaek.service;

import no.bouvet.sandvika.stabaek.domain.Table;
import no.bouvet.sandvika.stabaek.nifs.NifsTable;
import no.bouvet.sandvika.stabaek.utils.NifsTableTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TableService {

    @Autowired
    private NifsService nifsService;

    public Table getTable(){
        NifsTable nifsTable = nifsService.getNifsTable();
        if(nifsTable == null) return null;
        return NifsTableTranslator.getTable(nifsTable);
    }

}
