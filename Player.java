public class Player
{
	private String name;
	private int runs_scored;
	private int balls_faced;
	private float strike_rate;
	private int fours=0;
	private int sixes=0;
    private int wickets=0;
	private int overs_bowled;
	private int runs_given=0;
	private float economy;
	private Role role;

	public static enum Role {
		BATSMAN, BOWLER, ALLROUNDER;
	}

   public Player(String name, Role role) 
   {
		this.name = name;
		this.role = role;
	}

   public void CountRuns(int r) 
   {
		runs_scored += r;
   }

	public void CountBallsfaced()
	{
		balls_faced++;
	}

	public void CountSix() 
	{
		sixes++;
	}

	public void CountFour() 
	{
		fours++;
	}
	public void CountWickets()
	{
		wickets++;
	}

	public void CountOvers()
	{
		overs_bowled++;
	}
    
    public void RunsGiven(int r)
    {
    	runs_given+=r;
    }

    public String GetPlayerName()
    {
   	   return this.name;
    }
 
   public float GetStrikerate()
   {
   	     	strike_rate = (runs_scored>0) ? ((runs_scored/balls_faced) * 100 ) : 0;   	         
   	        return strike_rate;
   }

   public float GetEconomy()
   {
         economy = (overs_bowled >0) ? (runs_given/overs_bowled) : 0;
         return economy;
   }

   public int GetSix()
    {
    	return sixes;
    }
   public int Getfour()
    {
    	return fours;
    }

   public int GetWickets()
    {
    	return wickets;
    }
    public int GetRunsScored()
    {
    	return runs_scored;
    }
    public int BallsFaced()
    {
    	return balls_faced;
    }


}