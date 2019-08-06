package com.cricket;
public class Player
{
    private String name;
    private int playerid;

    private Role role;
    DbConnection playerobj = new DbConnection();

    public static enum Role {
        BATSMAN, BOWLER, ALLROUNDER;
    }

    public Player(int playerid, String name, Role role) {
        this.playerid = playerid;
        this.name = name;
        this.role = role;
    }

    public void CountRuns(int r) {
        playerobj.runsScored(this.playerid, r);
    }

    public void CountBallsfaced() {
        playerobj.countBallsFaced(this.playerid);
    }

    public void CountSix() {
        playerobj.countSix(this.playerid);
    }

    public void CountFour() {
        playerobj.countFour(this.playerid);
    }

    public void CountWickets() {
        playerobj.countWicket(this.playerid);
    }

    public void CountOvers() {
        playerobj.countOversBowled(this.playerid);
    }

    public void RunsGiven(int r) {
        playerobj.runsGiven(this.playerid, r);
    }

    public String GetPlayerName() {

        return this.name;
    }

}
