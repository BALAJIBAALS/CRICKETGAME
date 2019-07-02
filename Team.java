import java.util.ArrayList;

public class Team
 {
	private ArrayList<Player> players;
	private String name;
	private int wickets = 0;
	private int score= 0;
    int [][] scorecard = new int[5][6];
    int [][] wicket_fall = new int[5][6];

  
    public void addPlayers(ArrayList<Player> team) 
    {
		players = new ArrayList<>(team);
	}

	public Team(String name, ArrayList<Player> players) 
	{
		this.name = name;
		addPlayers(players);
	}

	public void out() {
		wickets++;
	}

	public void addScore(int n) {
		score+=n;
	}
	
	public int getWickets() {
		return this.wickets;
	}

		
	public String getTeamName()
	{
		return this.name;
	}
	
	public int getTeamScore() {
		return this.score;
	}
	
	public Player nthPlayer(int n) {
		return players.get(n);
	}


	public void setName(String name)
	{
		this.name = name;
		
	}

	public void SetScoreuptoEachBall(int overs,int balls)
	{
		scorecard[overs][balls] = this.getTeamScore();
		wicket_fall[overs][balls] = this.getWickets();
	}
	public void GetScoreuptoEachBall(int overs,int balls)
	{
		System.out.println("The score when" +overs+ " . " +balls+ " is "+scorecard[overs][balls] +" for the loss of "+wicket_fall[overs][balls]);
			
	}
	
}