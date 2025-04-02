import java.text.DecimalFormat;
import java.util.Arrays;

public class TennisPlayer {

    private String name;
    private String country;
    private int tournamentWins;
    private double serve;
    private double forehand;
    private double backhand;
    private double volley;
    private double movement;

    //Create the constructor
    TennisPlayer(String name, String country, int tournamentWins, double serve, double forehand, double backhand, double volley, double movement) {
        this.name = name;
        this.country = country;
        this.tournamentWins = tournamentWins;
        this.serve = serve;
        this.forehand = forehand;
        this.backhand = backhand;
        this.volley = volley;
        this.movement = movement;
    }

    //Set up the Getters

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public int getTournamentWins() {
        return tournamentWins;
    }

    public double getServe() {
        return serve;
    }

    public double getForehand() {
        return forehand;
    }

    public double getBackhand() {
        return backhand;
    }

    public double getVolley() {
        return volley;
    }

    public double getMovement() {
        return movement;
    }

    // Calculate an overall skill rating (average of all skill ratings)
    public String avgSkillRating() {
        double average = ((serve + forehand + backhand + volley + movement) / 5.0);
        // Convert to percentage (out of 10 becomes out of 100)
        double percentage = (average / 10.0) * 100.0;
        DecimalFormat df = new DecimalFormat("0.#"); //"0" means always show a digit in this position / ".#" means show one decimal digit only if needed
        return "Average Rating Skill: " + df.format(percentage) + "%";
    }

    public double getAvgSkillRating() {
        double average = ((serve + forehand + backhand + volley + movement) / 5.0);
        return (average / 10.0) * 100.0;
    }

    // Determine the player's strongest skill
    public String strongestSkill() {
        //Make an array list of skills and use stream to return the max value.
        double highestSkillScore = Arrays.stream(new double[] {serve, forehand, backhand, volley, movement})
                .max()
                .getAsDouble();
        if (serve == highestSkillScore) {
            return "serve";
        } else if (forehand == highestSkillScore) {
            return "forehand";
        } else if (backhand == highestSkillScore) {
            return "backhand";
        } else if (volley == highestSkillScore) {
            return "volley";
        } else {
            return "movement";
        }
    }

    //Calculate a "success efficiency" (tournament wins divided by overall skill)
    public String successEfficiency() {
        double overallSuccess = tournamentWins / ((serve + forehand + backhand + volley + movement) / 5.0);
        DecimalFormat df = new DecimalFormat("0.#");
        return "He won " + df.format(overallSuccess) + "%" + " Of all lifetime tournaments.";
    }

    // Display the overall player profile in a formated way.
    public String toString() {
        return "TENNIS PLAYER:\n" +
                name + " (" + country + ")" + "\n"+
                "Serve: " + serve + ", " + "Forehand: " + forehand + ", " +
                "Backhand: " + backhand + "," + " Volley: " + volley + ", " +
                "Movement: " + movement + "\n" +
                "Tournament Wins: " + tournamentWins + "\n" +
                avgSkillRating() + "\n" +
                strongestSkill() + "\n";
    }
}


