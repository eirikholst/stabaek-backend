package no.bouvet.sandvika.stabaek.utils;

import no.bouvet.sandvika.stabaek.domain.Transfer;
import no.bouvet.sandvika.stabaek.nifs.NifsTransfer;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class NifsTransferTranslator {

    private static Transfer getTransfer(NifsTransfer nifsTransfer) {
        return new Transfer(
                nifsTransfer.getFromTeam().getName(),
                nifsTransfer.getToTeam().getName(),
                Integer.toString(nifsTransfer.getFromTeam().getId()),
                Integer.toString(nifsTransfer.getToTeam().getId()),
                nifsTransfer.getDate()
        );
    }

    public static List<Transfer> getTransfers(NifsTransfer[] transfers) {
        if(transfers == null) return null;
        return Arrays.stream(transfers)
                .map(NifsTransferTranslator::getTransfer)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }
}
