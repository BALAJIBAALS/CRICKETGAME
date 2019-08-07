package com.cricket;

public class MatchController
{

    public Match match = Match.getMatch();

    public void toss(Team t1,Team t2)
    {
        if (Math.random() > 0 && Math.random() <= 0.25)
        {
            System.out.println(t1.getTeamName()+" won the toss and choose to bat first");
            match.startmatch(t1,t2);
        }
        else if(Math.random() > 0.25 && Math.random() <= 0.5)
        {
            System.out.println(t2.getTeamName()+" won the toss and choose to bowl first");
            match.startmatch(t1,t2);
        }
        else if(Math.random() > 0.5 && Math.random() <= 0.75)
        {
            System.out.println(t2.getTeamName()+" won the toss and choose to bat first");
            match.startmatch(t2,t1);
        }
        else
        {
            System.out.println(t1.getTeamName()+" won the toss and choose to bowl first");
            match.startmatch(t2,t1);
        }
    }

}
