package org.ammolite.likxbit.models.tournament;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
public class TournamentRound {
    @Id
    private long roundId;

    @ManyToOne
    private TournamentTeam teamA;
    @ManyToOne
    private TournamentTeam teamB;

    private Date roundStartDate;
    @ManyToOne
    private TournamentTeam winner;

}
