import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TennisPlayer federer = new TennisPlayer("Roger Federer", "Switzerland", 103, 8.5, 9.7, 8.3, 9.2, 10.0);
        TennisPlayer djokovic = new TennisPlayer("Novak Djokovic", "Serbia", 99, 8.8, 9.3, 9.5, 8.4, 9.6);
        TennisPlayer nadal = new TennisPlayer("Rafael Nadal", "Spain", 92, 9.2, 10.0, 8.7, 8.3, 9.5);
        TennisPlayer tien = new TennisPlayer("Dominic Tien", "Austria", 17, 8.4, 8.2, 10.0, 8.1, 7.9);
        TennisPlayer wawrinka = new TennisPlayer("Stan Wawrinka", "Switzerland", 16, 10.0, 8.5, 10.0, 7.6, 10.0);
        TennisPlayer murray = new TennisPlayer("Andy Murray", "Great Britain", 46, 8.3, 9.1, 9.4, 7.8, 8.7);

        //Find and display the player with the highest overall skill
        TennisPlayer[] players = {federer, djokovic, nadal, tien, wawrinka, murray};

        //Find the player with the highest skill rating
        TennisPlayer bestplayer = players[0];
        for (TennisPlayer player : players) {
            if (player.getAvgSkillRating() > bestplayer.getAvgSkillRating()) {
                bestplayer = player;
            }
        }

        // Find the player with the most tournament wins
        TennisPlayer highestPlayerWins = players [0];
        for (TennisPlayer player : players) {
            if (player.getTournamentWins() > highestPlayerWins.getTournamentWins()) {
                highestPlayerWins = player;
            }
        }

        //Display the player with the highest skill rating
        System.out.println(bestplayer.getName() + " has got the highest overall skill");

        //Display the player with the most tournament wins
        System.out.println(highestPlayerWins.getName() + " has got the most tournament wins");


        // Group and display players by their strongest skill
        List<TennisPlayer> bestServers = new ArrayList<>();
        List<TennisPlayer> bestForehands = new ArrayList<>();
        List<TennisPlayer> bestBackhands = new ArrayList<>();
        List<TennisPlayer> bestVolleys = new ArrayList<>();
        List<TennisPlayer> bestMovements = new ArrayList<>();

        for (TennisPlayer player : players) {
            String strongestSkill = player.strongestSkill();

            switch (strongestSkill) {
                case "serve":
                    bestServers.add(player);
                    break;
                case "forehand":
                    bestForehands.add(player);
                    break;
                case "backhand":
                    bestBackhands.add(player);
                    break;
                case "volley":
                    bestVolleys.add(player);
                    break;
                case "movement":
                    bestMovements.add(player);
                    break;
            }
        }

        System.out.println("\nPLAYERS BY STRONGEST SKILL:");
        System.out.println("Best Servers:");
        for (TennisPlayer player: bestServers) {
            System.out.println(" " + player.getName() + "(" + player.getServe() + ")");
        }
        System.out.println("\nBest Forehand Players:");
        for (TennisPlayer player: bestForehands) {
            System.out.println(" " + player.getName() + "(" + player.getForehand() + ")");
        }
        System.out.println("\nBest Backhand Players:");
        for (TennisPlayer player: bestBackhands) {
            System.out.println(" " + player.getName() + "(" + player.getBackhand() + ")");
        }
        System.out.println("\nBest Volley Players:");
        for (TennisPlayer player: bestVolleys) {
            System.out.println(" " + player.getName() + "(" + player.getVolley() + ")");
        }
        System.out.println("\nBest Movement Players:");
        for (TennisPlayer player: bestMovements) {
            System.out.println(" " + player.getName() + "(" + player.getMovement() + ")");
        }

    }
}