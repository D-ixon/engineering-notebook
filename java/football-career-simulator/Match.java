import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class MatchDay{
    String homeTeam;
    String awayTeam;
    int homeTeamScore;
    int awayTeamScore;
    int matchDuration = 90;


    public MatchDay(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore, int matchDuration){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.matchDuration = matchDuration;
    }

    public void simulateMatch() {

        System.out.println("And its show Time! " + this.homeTeam + " vs " + this.awayTeam + "\n");

        // Array Object of player - so as to be able to iclude goal scorers 
        Tracker[] track = new Tracker[4];
        track[0] = new Tracker("Anthony", "LW", "Leeds", 21, 77, 78, 78, 80);
        track[1] = new Tracker("Williams", "LW", "Leeds", 29, 97, 78, 78, 80);
        track[2] = new Tracker("Jake", "ST", "Spurs", 24, 79, 78, 78, 80);
        track[3] = new Tracker("Green", "DM", "Spurs", 21, 77, 78, 78, 80);

        // A random object rand is created from the java utility Random class
        Random rand = new Random();

        // For loop - simulates match including goals, goal scorers, events like yellow cards, red cards. This is made possible using randomness.
        for (int minute = 1; minute <= matchDuration; minute++) {
            
            // eventChance a value probability evaluation
            int eventChance = rand.nextInt(100);

            // goals, simulate goals and goal scorers 
            if (eventChance < 3) {
                boolean isHomeGoal = rand.nextBoolean(); // generates between 0 and 1
                String scoringTeam;

                if (isHomeGoal) {
                    this.homeTeamScore++;
                    scoringTeam = this.homeTeam;
                } else {
                    this.awayTeamScore++;
                    scoringTeam = this.awayTeam;
                }

                // 1. Collect all players from the scoring team
                List <Tracker> eligibleScorers = new ArrayList<>();

                for (Tracker player : track) {
                    // If a player in the track array, is in the scoring team, then add that player to the eligibleScorers list
                    if (player.getClub().equals(scoringTeam)) {
                        eligibleScorers.add(player);
                    }
                }

                // 2. Pick ONE random player from that team to score

                /* To pick one random player from that list at random, first check if list is not empty if not
                then using the .nextInt() method of random, choose a random interger based on the size of the list 
                */
                if (!eligibleScorers.isEmpty()) {
                    Tracker scorer = eligibleScorers.get(rand.nextInt(eligibleScorers.size()));
                    scorer.playMatch(1, 0, 0.0);

                    System.out.println(minute + "' - Goal! " + scorer.getName() + " (" + scoringTeam + ") "
                        + this.homeTeam + " " + this.homeTeamScore + " - "
                        + this.awayTeam + " " + this.awayTeamScore
                    );
                } else {
                    // Fallback if no players in 'track' belong to scoringTeam
                    System.out.println(minute + "' - Goal! " + this.homeTeam + " " + this.homeTeamScore + " - "
                        + this.awayTeam + " " + this.awayTeamScore
                    );
                }

            // Yellow card offenses based on chances less than 8%
            } else if (eventChance < 8) {
                String bookedTeam = rand.nextBoolean() ? this.homeTeam : this.awayTeam;
                System.out.println(minute + "' - YELLOW CARD for " + bookedTeam + ".");
            }
            // ~1% chance for a red card
            else if (eventChance == 8) {
                String sentOffTeam = rand.nextBoolean() ? this.homeTeam : this.awayTeam;
                System.out.println(minute + "' - RED CARD! A player from " + sentOffTeam + " is sent off!");
            }
            // ~6% chance for a near-miss / big save to add flavor
            else if (eventChance < 15) {
                String attackingTeam = rand.nextBoolean() ? this.homeTeam : this.awayTeam;
                System.out.println(minute + "' - Close call! Great save!!!!! " + attackingTeam + ".");
            }

            // Halftime marker
            if (minute == 45) {
                System.out.println("\n--- HALF TIME: " + this.homeTeam + " " + this.homeTeamScore + " - "
                        + this.awayTeamScore + " " + this.awayTeam + " ---\n");
            }
        }

    System.out.println("\n=== FULL TIME ===");
    System.out.println("Final Score: " + this.homeTeam + " " + this.homeTeamScore + " - " + this.awayTeamScore + " " + this.awayTeam);
}


}
public class Match {
    public static void main(String[] args){

        MatchDay match = new MatchDay("Leeds", "Spurs", 0, 0, 90);
        match.simulateMatch();

    }
}
