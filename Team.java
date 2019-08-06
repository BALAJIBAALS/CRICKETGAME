package com.cricket;

import java.util.ArrayList;

public class Team
{
    private int teamid;
    private ArrayList<Player> players;
    private String name;
    int [][] scorecard = new int[5][6];
    int [][] wicket_fall = new int[5][6];
    DbConnection teamobj = new DbConnection();

    public void addPlayers(ArrayList<Player> team)
    {
        players = new ArrayList<>(team);
    }

    public Team(int teamid,String name, ArrayList<Player> players)
    {
        this.teamid =teamid;
        this.name = name;
        addPlayers(players);
    }

    public void out(int matchid,int nthinings)
    {
        teamobj.addWicketFall(matchid,nthinings);
    }


    public void addScore(int score,int matchid,int nthinnings)
    {

        teamobj.addTeamScore(score,matchid,nthinnings);
    }

    public int getWickets(int matchid,int nthinnings)
    {

        return teamobj.getWickets(matchid,nthinnings);
    }
    public int getTeamScore(int matchid,int nthinnings)
    {

        return teamobj.getTeamScore(matchid,nthinnings);
    }

    public String getTeamName()
    {

        return this.name;
    }

    public int getTeamid()
    {
        return this.teamid;
    }



    public Player nthPlayer(int n)
    {

        return players.get(n);
    }


   /* public void SetScoreuptoEachBall(int overs,int balls)
    {
        scorecard[overs][balls] = this.getTeamScore();
        wicket_fall[overs][balls] = this.getWickets();
    }
    public void GetScoreuptoEachBall(int overs,int balls)
    {
        System.out.println("The score when" +overs+ " . " +balls+ " is "+scorecard[overs][balls] +" for the loss of "+wicket_fall[overs][balls]);

    }
 */
}
