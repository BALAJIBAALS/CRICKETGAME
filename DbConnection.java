package com.cricket;

import java.sql.*;

public class DbConnection
{
    // JAVA PROGRAM TO DO BASIC DB OPERATIONS WITH MYSQL
    public String playingEleven(int playerid)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(" SELECT name FROM cricketgame.Player where id="+playerid+";");
            rs.next();
            String name = rs.getString(1);
            con.close();
            return name;
        } catch (Exception e) { System.out.println(e); return null;}


    }

    public String getTeamName(int teamid)
    {

        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT name FROM cricketgame.Team where idTeam="+teamid+";");
            rs.next();
            String name = rs.getString(1);
            mysqlConnection().close();
            return name;
        } catch (Exception e) { System.out.println(e); return null;}
    }

    public void countFour(int playerid)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE cricketgame.Player SET fours=fours+1 where id="+playerid+";");
            con.close();
        } catch (Exception e) { System.out.println(e);}
    }

    public void countSix(int playerid)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE cricketgame.Player SET sixes=sixes+1 where id="+playerid+";");
            con.close();
        } catch (Exception e) { System.out.println(e);}
    }

    public void countBallsFaced(int playerid)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE cricketgame.Player SET balls_faced=balls_faced+1 where id="+playerid+";");
            con.close();
        } catch (Exception e) { System.out.println(e);}

    }

    public void runsScored(int playerid,int runs)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE cricketgame.Player SET runs_scored=runs_scored+"+runs+"  where id="+playerid+";");
            con.close();
        } catch (Exception e) { System.out.println(e);}

    }

    public void countWicket(int playerid)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE cricketgame.Player SET wickets=wickets+1 where id="+playerid+";");
            con.close();
           } catch (Exception e) { System.out.println(e);}

    }

    public void countOversBowled(int playerid)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE cricketgame.Player SET overs_bowled=overs_bowled+1 where id="+playerid+";");
            con.close();
        } catch (Exception e) { System.out.println(e);}

    }

    public void runsGiven(int playerid,int runs)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("UPDATE cricketgame.Player SET runs_given=runs_given+"+runs+" where id="+playerid+";");
            con.close();
        } catch (Exception e) { System.out.println(e);}

    }


    public int  newMatch(String team1,String team2,int team1id,int team2id)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            stmt.executeUpdate("INSERT INTO `cricketgame`.`Match` (`Team1`, `Team2`) VALUES ('"+team1+"', '"+team2+"');");
            stmt.executeUpdate("UPDATE cricketgame.Team SET matches_played=matches_played+1 where idTeam="+team1id+";");
            stmt.executeUpdate("UPDATE cricketgame.Team SET matches_played=matches_played+1 where idTeam="+team2id+";");
            ResultSet rs =stmt.executeQuery( "SELECT matchid FROM cricketgame.Match ORDER BY matchid  DESC LIMIT 1;");
            rs.next();
            int match_id = rs.getInt(1);
            con.close();
            return match_id;
        } catch (Exception e) { System.out.println(e); return 0;}
    }




    public void result(int winningteamid,int losingteamid,int draw)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            if(draw==1)
               {
                stmt.executeUpdate("UPDATE cricketgame.Team SET tied=tied+1 where idTeam="+winningteamid+";");
                stmt.executeUpdate("UPDATE cricketgame.Team SET tied=tied+1 where idTeam="+losingteamid+";");

               }
            else
                {
                stmt.executeUpdate("UPDATE cricketgame.Team SET won=won+1 where idTeam="+winningteamid+";");
                stmt.executeUpdate("UPDATE cricketgame.Team SET lost=lost+1 where idTeam="+losingteamid+";");
                 }
            con.close();
        } catch (Exception e) { System.out.println(e);}
    }


    public void addTeamScore(int scorebyball,int matchid,int nthinnings)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();

            if(nthinnings==1)
            {
                stmt.executeUpdate("UPDATE cricketgame.Match SET Team1Score=Team1Score+"+scorebyball+" where matchid="+matchid+";");
            }
            else
            {
                stmt.executeUpdate("UPDATE cricketgame.Match SET Team2Score=Team2Score+"+scorebyball+" where matchid="+matchid+";");
            }

            con.close();
        } catch (Exception e) { System.out.println(e);}
    }

    public void addWicketFall(int matchid,int nthinnings)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            if(nthinnings==1)
            {
                stmt.executeUpdate("UPDATE cricketgame.Match SET Team1Wicket=Team1Wicket+1 where matchid="+matchid+";");
            }
            else
            {
                stmt.executeUpdate("UPDATE cricketgame.Match SET Team2Wicket=Team2Wicket+1 where matchid="+matchid+";");
            }
            con.close();
        } catch (Exception e) { System.out.println(e);}
    }

    public int getWickets(int matchid,int nthinnings)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            if(nthinnings==1)
            {
                rs = stmt.executeQuery("SELECT Team1Wicket FROM cricketgame.Match where matchid="+matchid+";");
                rs.next();
            }
            else
            {
                rs = stmt.executeQuery("SELECT Team2Wicket FROM cricketgame.Match where matchid="+matchid+";");
                rs.next();
            }
            int wicket = rs.getInt(1);
            con.close();
            return  wicket;
        } catch (Exception e) { System.out.println(e); return 0;}
    }

    public int getTeamScore(int matchid,int nthinnings)
    {
        try {
            Connection con = mysqlConnection();
            Statement stmt = con.createStatement();
            ResultSet rs;
            if(nthinnings==1)
            {
                rs=stmt.executeQuery("SELECT Team1Score FROM cricketgame.Match where matchid="+matchid+";");
                rs.next();
            }
            else
            {
                rs=stmt.executeQuery("SELECT Team2Score FROM cricketgame.Match where matchid="+matchid+";");
                rs.next();
            }

            int score = rs.getInt(1);
            con.close();
            return  score;
        } catch (Exception e) { System.out.println(e); return 0;}
    }



    public Connection mysqlConnection()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricketgame", "root", "balabala4");
            return con;
        } catch (Exception e) { System.out.println(e);return null;}

    }
}
