package no.bouvet.sandvika.stabaek.nifs;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class NifsLiveFeed {
    private String type;
    private int id;
    private String uid;
    private int customerId;
    private int matchId;
    private boolean prioritized;
    private boolean ended;
    @Embedded
    private NifsUser user;

    public NifsLiveFeed() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public boolean isPrioritized() {
        return prioritized;
    }

    public void setPrioritized(boolean prioritized) {
        this.prioritized = prioritized;
    }

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public NifsUser getUser() {
        return user;
    }

    public void setUser(NifsUser user) {
        this.user = user;
    }
}
