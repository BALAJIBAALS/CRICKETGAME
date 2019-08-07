package com.cricket;
import java.util.concurrent.*;

public class Match
{

    private static Match match = new Match();
    DbConnection matchobj = new DbConnection();


    public static Match getMatch()
    {
        return match;

    }
    private int matchid;

    private Team battingfirst,battingsecond;
    private Player batsman1,batsman2,bowler;
    public void startmatch(Team battingfirst, Team battingsecond)
    {

        matchid = matchobj.newMatch(battingfirst.getTeamName(),battingsecond.getTeamName(),battingfirst.getTeamid(),battingsecond.getTeamid());
        System.out.println(battingfirst.getTeamName() + "--->Batting first");
        innings(battingfirst,battingsecond,1);   // batting-first innings
        System.out.println(battingsecond.getTeamName() + "----> Batting second");
        innings(battingsecond,battingfirst,2);   //batting-second innings
        results(battingfirst,battingsecond);

    }

    public void innings(Team battingteam,Team bowlingteam,int nthinnings)
    {
        int striker =0,bowlerpos =11,teamscore =0,overcount = 0,run_for_each_ball;
        String outcome,strikerbatsman;
        boolean allout = false;
        batsman1 = battingteam.nthPlayer(striker);
        batsman2 = battingteam.nthPlayer(++striker);
        while(overcount<5 &&  battingteam.getWickets(matchid,nthinnings)<10)
        {
            System.out.println("Over number" +overcount);
            bowler = bowlingteam.nthPlayer(--bowlerpos);
            int ball =0;
            while(ball<=5  && battingteam.getWickets(matchid,nthinnings)<10)
            {

                System.out.println("Bowler Name ------>"+bowler.GetPlayerName());
                int ballnumber =ball+1;
                System.out.println("Ballnumber" +ballnumber);
                strikerbatsman=batsman1.GetPlayerName();
                System.out.println("Batsman at Striker End ------>"+strikerbatsman);
                ThreadLocalRandom runs = ThreadLocalRandom.current();
                run_for_each_ball = runs.nextInt(-1,7);

                if(run_for_each_ball ==4)
                {
                    batsman1.CountFour();

                }
                if(run_for_each_ball ==6)
                {
                    batsman1.CountSix();
                }

                if(run_for_each_ball == -1) // if wicket occurs
                {
                    System.out.println("OUT ----------------->"+strikerbatsman+" BY "+ bowler.GetPlayerName());
                    battingteam.out(matchid,nthinnings);  // team out
                    battingteam.addScore(0,matchid,nthinnings); // team runs
                    bowler.CountWickets();  // adding wickets to bowler
                    bowler.RunsGiven(0);  // adding runs-given by bowler
                    batsman1.CountRuns(0); // batsman runs
                    batsman1.CountBallsfaced(); // batsman ballsfaced
                    batsman1 =battingteam.nthPlayer(++striker);

                }
                else
                {
                    System.out.println("The runs scored-->"+run_for_each_ball);
                    battingteam.addScore(run_for_each_ball,matchid,nthinnings); //  team runs
                    bowler.RunsGiven(run_for_each_ball); // adding runs-given by bowler
                    batsman1.CountRuns(run_for_each_ball); // batsman runs
                    batsman1.CountBallsfaced(); // batsman ballsfaced


                }
                outcome =(run_for_each_ball ==-1)? "W" : Integer.toString(run_for_each_ball);

                matchobj.scoreperball(matchid,nthinnings,battingteam.getTeamName(),overcount,ballnumber,strikerbatsman,bowler.GetPlayerName(),outcome);

                if((run_for_each_ball !=-1) && ((run_for_each_ball %2 ==1) || ball==5) && battingteam.getWickets(matchid,nthinnings)<10)  //switch batsman only if batsman is available
                {
                    Player switchbatsman = batsman1;
                    batsman1 =batsman2;
                    batsman2 =switchbatsman;
                    System.out.println ("The strike has been interchanged");
                }

                ++ball;
            }
            bowler.CountOvers();

            overcount++;


        }

    }

    public void results(Team t1,Team t2)
    {
        int diff = t1.getTeamScore(matchid,1) - t2.getTeamScore(matchid,2);
        System.out.println("------------RESULTS-----------------------------------------");

        if(diff>0)
        {
            System.out.println (t1.getTeamName() + "won the match by" +diff +"runs");
            matchobj.result(t1.getTeamid(),t2.getTeamid(),0);

        }
        else if(diff==0)
        {
            System.out.println("Match Tied between " +t1.getTeamName()+ " and "+ t2.getTeamName());
            matchobj.result(t1.getTeamid(),t2.getTeamid(),1);
        }
        else
        {

            System.out.println (t2.getTeamName() + "won the match by"+ t2.getWickets(matchid,2) +"wickets");
            matchobj.result(t2.getTeamid(),t1.getTeamid(),0);
        }
        System.out.println("------------GAME OVER-----------------------------------------");

    }
}
