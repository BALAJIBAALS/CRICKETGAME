import java.util.Scanner;
import java.util.ArrayList;

public class CricketGame
{
	public static void main(String[] args) 
	{
		ArrayList<Player>india = new ArrayList<>();

		Player player1 = new Player("Rohit Sharma",Player.Role.BATSMAN);
		Player player2 = new Player("KL Rahul",Player.Role.BATSMAN);
		Player player3 = new Player("Virat Kohli",Player.Role.BATSMAN);
		Player player4 = new Player("Dinesh Karthik",Player.Role.BATSMAN);
		Player player5 = new Player("Rishabh Pant",Player.Role.BATSMAN);
		Player player6 = new Player("MS Dhoni",Player.Role.BATSMAN);
		Player player7 = new Player("Hardik Pandya",Player.Role.ALLROUNDER);
		Player player8 = new Player("Bhuvneshwar Kumar",Player.Role.BOWLER);
		Player player9 = new Player("Mohammed Shami",Player.Role.BOWLER);		
		Player player10 = new Player("Yuzvendra Chahal",Player.Role.BOWLER);
		Player player11 = new Player("Jasprit Bumrah",Player.Role.BOWLER);
    
       india.add(player1);
       india.add(player2);
       india.add(player3);
       india.add(player4);
       india.add(player5);
       india.add(player6);
       india.add(player7);
       india.add(player8);
       india.add(player9);
       india.add(player10);
       india.add(player11);

       ArrayList<Player>australia = new ArrayList<>();

      Player opponent1 = new Player("Aaron Finch",Player.Role.BATSMAN);
      Player opponent2 = new Player("David Warner",Player.Role.BATSMAN);
      Player opponent3 = new Player("Usman Khawaja",Player.Role.BATSMAN);
      Player opponent4 = new Player("Steve Smith",Player.Role.BATSMAN);
      Player opponent5 = new Player("Glenn Maxwell",Player.Role.BATSMAN);
      Player opponent6 = new Player("Alex Carey",Player.Role.BATSMAN);
      Player opponent7 = new Player("Marcus Stoinis",Player.Role.ALLROUNDER);      
      Player opponent8 = new Player("Pat Cummins",Player.Role.BATSMAN);
      Player opponent9 = new Player("Mitchel Starc",Player.Role.BATSMAN);
      Player opponent10 = new Player("Nathan Lyon",Player.Role.BATSMAN);
      Player opponent11 = new Player("Jason Behrendorff",Player.Role.BATSMAN);

      australia.add(opponent1);
      australia.add(opponent2);
      australia.add(opponent3);
      australia.add(opponent4);
      australia.add(opponent5);
      australia.add(opponent6);
      australia.add(opponent7);
      australia.add(opponent8);
      australia.add(opponent9);
      australia.add(opponent10);
      australia.add(opponent11);

      MatchController control = new MatchController();

		System.out.println("India vs Australia Match Starts");


         Team t1 = new Team("IndiaSuperXI",india);  //team 1
	     Team t2 = new Team("AustraliaSuperXI",australia);

		control.toss(t1,t2); // toss and match starts in Match Class
	}
}
