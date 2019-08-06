package com.cricket;
import java.util.ArrayList;

public class CricketGame
{
    public static void main(String[] args)
    {
        ArrayList<Player>india = new ArrayList<>();
        ArrayList<Player>australia = new ArrayList<>();
        Player player1,player2,player3,player4,player5,player6,player7,player8,player9,player10,player11;
        Player opponent1,opponent2,opponent3,opponent4,opponent5,opponent6,opponent7,opponent8,opponent9,opponent10,opponent11;
        DbConnection dbconnector = new DbConnection();

        player1 = new Player(1,dbconnector.playingEleven(1) ,Player.Role.BATSMAN);
        player2 = new Player(2,dbconnector.playingEleven(2) , Player.Role.BATSMAN);
        player3 = new Player(3,dbconnector.playingEleven(3), Player.Role.BATSMAN);
        player4 = new Player(4,dbconnector.playingEleven(4), Player.Role.BATSMAN);
        player5 = new Player(5,dbconnector.playingEleven(5), Player.Role.BATSMAN);
        player6 = new Player(6,dbconnector.playingEleven(6), Player.Role.ALLROUNDER);
        player7 = new Player(7,dbconnector.playingEleven(7), Player.Role.ALLROUNDER);
        player8 = new Player(8,dbconnector.playingEleven(8), Player.Role.ALLROUNDER);
        player9 = new Player(9,dbconnector.playingEleven(9), Player.Role.BOWLER);
        player10 = new Player(10,dbconnector.playingEleven(10), Player.Role.BOWLER);
        player11 = new Player(11,dbconnector.playingEleven(11), Player.Role.BOWLER);


        opponent1 = new Player(12,dbconnector.playingEleven(12), Player.Role.BATSMAN);
        opponent2 = new Player(13,dbconnector.playingEleven(13), Player.Role.BATSMAN);
        opponent3 = new Player(14,dbconnector.playingEleven(14), Player.Role.BATSMAN);
        opponent4 = new Player(15,dbconnector.playingEleven(15), Player.Role.BATSMAN);
        opponent5 = new Player(16,dbconnector.playingEleven(16), Player.Role.ALLROUNDER);
        opponent6 = new Player(17,dbconnector.playingEleven(17), Player.Role.ALLROUNDER);
        opponent7 = new Player(18,dbconnector.playingEleven(18), Player.Role.ALLROUNDER);
        opponent8 = new Player(19,dbconnector.playingEleven(19), Player.Role.BATSMAN);
        opponent9 = new Player(20,dbconnector.playingEleven(20), Player.Role.BATSMAN);
        opponent10 = new Player(21,dbconnector.playingEleven(21), Player.Role.BATSMAN);
        opponent11 = new Player(22,dbconnector.playingEleven(22), Player.Role.BATSMAN);



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
        String team1 = dbconnector.getTeamName(1);
        String team2 =dbconnector.getTeamName(2);
        System.out.println(team1+ "vs" +team2+ "Match Starts");


        Team t1 = new Team(1,team1,india);  //team 1
        Team t2 = new Team(2,team2,australia); // team2

        control.toss(t1,t2); // toss and match starts in Match Class
    }
}
