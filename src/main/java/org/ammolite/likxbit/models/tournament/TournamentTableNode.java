package org.ammolite.likxbit.models.tournament;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Entity
public class TournamentTableNode {
    @Id
    long id;
    @ManyToOne
    Tournament tournament;

    @ManyToOne
    TournamentRound round;
    @OneToOne
    TournamentTableNode parent = null;
    @OneToOne
    TournamentTableNode left = null;
    @OneToOne
    TournamentTableNode right = null;

    public TournamentTableNode(Tournament tournament) {
        this.tournament = tournament;
        this.init(tournament.getTotalStages()-1);
    }

    public TournamentTableNode(TournamentTableNode parent, Tournament tournament){
        this.tournament = tournament;
        this.parent = parent;
    }

    private void init(int stages){
        if(stages!=0){
            this.left = new TournamentTableNode(this, this.tournament);
            this.left.init(stages-1);
            this.right = new TournamentTableNode(this, this.tournament);
            this.right.init(stages-1);
        }
    }

    public ArrayList<TournamentTableNode> getStage(int stage) throws Exception { //BFT
        stage -=1;
        if(stage == 0)
            return new ArrayList<TournamentTableNode>(List.of(this));
        else{
            var c = this.left.getStage(stage);
            var r = c.addAll(this.right.getStage(stage));
            if(r)
                return c;
            else
                throw new Exception();
        }
    }
    public TournamentTableNode(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public TournamentRound getRound() {
        return round;
    }

    public void setRound(TournamentRound round) {
        this.round = round;
    }

    public TournamentTableNode getParent() {
        return parent;
    }

    public void setParent(TournamentTableNode parent) {
        this.parent = parent;
    }

    public TournamentTableNode getLeft() {
        return left;
    }

    public void setLeft(TournamentTableNode left) {
        this.left = left;
    }

    public TournamentTableNode getRight() {
        return right;
    }

    public void setRight(TournamentTableNode right) {
        this.right = right;
    }
}
