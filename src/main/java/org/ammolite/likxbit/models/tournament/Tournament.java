package org.ammolite.likxbit.models.tournament;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
public class Tournament {
    @Id
    private long tournamentId;

    private String tournamentDescription;

    private Date regisrationEndDate;
    private Date tournamentStartDate;

    @OneToOne
    private TournamentTableNode root;

    private int totalStages;

    public Tournament() {
    }

    public int getTotalStages() {
        return totalStages;
    }

    public void setTotalStages(int totalStages) {
        this.totalStages = totalStages;
    }

    public long getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(long tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentDescription() {
        return tournamentDescription;
    }

    public void setTournamentDescription(String tournamentDescription) {
        this.tournamentDescription = tournamentDescription;
    }

    public Date getRegisrationEndDate() {
        return regisrationEndDate;
    }

    public void setRegisrationEndDate(Date regisrationEndDate) {
        this.regisrationEndDate = regisrationEndDate;
    }

    public Date getTournamentStartDate() {
        return tournamentStartDate;
    }

    public void setTournamentStartDate(Date tournamentStartDate) {
        this.tournamentStartDate = tournamentStartDate;
    }

    public TournamentTableNode getRoot() {
        return root;
    }

    public void setRoot(TournamentTableNode root) {
        this.root = root;
    }
}
