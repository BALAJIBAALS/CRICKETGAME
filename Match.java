import java.util.concurrent.*;
import java.util.*;


public class Match
{

 private static Match match = new Match();


 public static Match getMatch() 
   {
		return match;
	
   }


private Team battingfirst,battingsecond;
private Player batsman1,batsman2,bowler;




public void startmatch(Team battingfirst, Team battingsecond)  
   {
		System.out.println(battingfirst.getTeamName() + "--->Batting first");
		innings(battingfirst,battingsecond);   // batting-first innings
		System.out.println(battingsecond.getTeamName() + "----> Batting second");
		innings(battingsecond,battingfirst);   //batting-second innings
		results(battingfirst,battingsecond);

	}

public void innings(Team battingteam,Team bowlingteam)
{
       int striker =0,bowlerpos =11,teamscore =0,overcount = 0,run_for_each_ball;
        boolean allout = false;
     	batsman1 = battingteam.nthPlayer(striker);
		batsman2 = battingteam.nthPlayer(++striker);
	   while(overcount<5 &&  battingteam.getWickets()<10)        	
       {    
       	     System.out.println("Over number" +overcount);
       	     bowler = bowlingteam.nthPlayer(--bowlerpos);
       	    int ball =0;
		   while(ball<=5  && battingteam.getWickets()<10) 
		  { 

              System.out.println("Bowler Name ------>"+bowler.GetPlayerName());
               int ballnumber =ball+1;
              System.out.println("Ballnumber" +ballnumber);
              System.out.println("Batsman at Striker End ------>"+batsman1.GetPlayerName());
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
             	battingteam.out();
             	System.out.println("OUT ----------------->"+batsman1.GetPlayerName()+" BY "+ bowler.GetPlayerName());
           	    bowler.CountWickets();  // adding wickets to bowlwe
             	batsman1.CountRuns(0); 
             	batsman1.CountBallsfaced(); // ballsfaced
             	bowler.RunsGiven(0);  // 
             	battingteam.addScore(0); // 
             	batsman1 =battingteam.nthPlayer(++striker);

             }  
             else
             {
               System.out.println("The runs scored-->"+run_for_each_ball);
               batsman1.CountRuns(run_for_each_ball); // adding runs
               bowler.RunsGiven(run_for_each_ball); // bowler given runs
               battingteam.addScore(run_for_each_ball); // adding run to team

             }

            battingteam.SetScoreuptoEachBall(overcount,ball); // to track the score upto each ball and calls the Team class to store

              if((run_for_each_ball !=-1) && ((run_for_each_ball %2 ==1) || ball==5) && battingteam.getWickets()<10)  //switch batsman only if batsman is available
              {
              	Player switchbatsman = batsman1;
              	batsman1 =batsman2;
              	batsman2 =switchbatsman;
               System.out.println ("The strike has been interchanged");
              }

            ++ball;	            
         }

         overcount++;

                 
		}

}

public void results(Team t1,Team t2)
{
	int diff = t1.getTeamScore() - t2.getTeamScore();
	System.out.println("------------RESULTS-----------------------------------------");

  if(diff>0)
  {
  	System.out.println (t1.getTeamName() + "won the match by" +diff +"runs");
  }
  else if(diff ==0)
  {
  	System.out.println("Match Tied between " +t1.getTeamName()+ " and "+ t2.getTeamName());
  }
  else
  {

  	System.out.println (t2.getTeamName() + "won the match by"+ t2.getWickets() +"wickets");
  }
  System.out.println("------------GAME OVER-----------------------------------------");

}

// ----------SCORECARD FOR EACH BALL -----------------------------------------------------
/*
 battingfirst.GetScoreuptoEachBall(4,2); // uncomment to get the score at a particular instance
*/



}