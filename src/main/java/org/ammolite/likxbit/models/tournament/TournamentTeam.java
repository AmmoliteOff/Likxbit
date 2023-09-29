package org.ammolite.likxbit.models.tournament;

import jakarta.persistence.*;
import org.ammolite.likxbit.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class TournamentTeam {
    @Id
    private String teamName;
    @OneToMany
    private List<User> players = new ArrayList<User>();

    @OneToOne
    private User captain;
    public TournamentTeam() {
    }

    public TournamentTeam(String teamName, List<User> players) {
        this.teamName = teamName;
        this.players = players;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<User> getPlayers() {
        return players;
    }

    public void setPlayers(List<User> players) {
        this.players = players;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TournamentTeam that = (TournamentTeam) o;
        return Objects.equals(teamName, that.teamName) && Objects.equals(players, that.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamName, players);
    }
}
