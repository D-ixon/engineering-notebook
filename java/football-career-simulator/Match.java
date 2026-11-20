import java.util.Random;

class MatchDay{
    String homeTeam;
    String awayTeam;
    int homeTeamScore;
    int awayTeamScore;
    int matchDuration;


    public MatchDay(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore, int matchDuration){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScore = homeTeamScore;
        this.awayTeamScore = awayTeamScore;
        this.matchDuration = matchDuration;
    }

    public void simulateMatch(String homeTeam, String awayTeam){

        System.out.println("And its show Time! " + this.homeTeam + " vs " + this.awayTeam + "\n");

        Tracker[] track = new Tracker[4];
        track[0] = new Tracker("Anthony", "LW", "Leeds", 21, 77, 78, 78, 80);
        track[1] = new Tracker("Williams", "LW", "Leeds", 29, 97, 78, 78, 80);
        track[2] = new Tracker("Jake", "ST", "Spurs", 24, 79, 78, 78, 80);
        track[3] = new Tracker("Green", "DM", "Spurs", 21, 77, 78, 78, 80);

        Random rand = new Random();
        int eventChance = rand.nextInt(100);
        
        for (int minute = 1; minute <= 90; minute++){
            for (Tracker track1 : track) {
                if (rand.nextInt(100) < 5) {
                    // 5% chance for a player to score or assist
                    int goals = rand.nextInt(2); // 0 or 1 goal
                    int assists = rand.nextInt(2); // 0 or 1 assist
                    double rating = 6.0 + (rand.nextDouble() * 4.0); // Random rating between 6.0 and 10.0
                    track1.playMatch(goals, assists, rating);
                }
            }
            if (eventChance < 3){
                boolean isHomeGoal = rand.nextBoolean();
                if (isHomeGoal){
                    homeTeamScore++;
                    System.out.println(minute + "' - Goal! " + homeTeam + " " + homeTeamScore + " - " + awayTeam + " " + awayTeamScore);
                }else{
                    awayTeamScore++;
                    System.out.println(minute + "' - Goal! " + homeTeam + " " + homeTeamScore + " - " + awayTeam + " " + awayTeamScore);
                }
            }else if (eventChance < 8) {
                String bookedTeam = rand.nextBoolean() ? homeTeam : awayTeam;
                System.out.println(minute + "' - YELLOW CARD for " + bookedTeam + ".");
            } 
            // ~1% chance for a red card
            else if (eventChance == 8) {
                String sentOffTeam = rand.nextBoolean() ? homeTeam : awayTeam;
                System.out.println(minute + "' - RED CARD! A player from " + sentOffTeam + " is sent off!");
            } 
            // ~6% chance for a near-miss / big save to add flavor
            else if (eventChance < 15) {
                String attackingTeam = rand.nextBoolean() ? homeTeam : awayTeam;
                System.out.println(minute + "' - Close call! Great save!!!!! " + attackingTeam + ".");
            }

            // Halftime marker
            if (minute == 45) {
                System.out.println("\n--- HALF TIME: " + homeTeam + " " + homeTeamScore + " - " + awayTeamScore + " " + awayTeam + " ---\n");
            }
            
        }
        System.out.println("\n=== FULL TIME ===");
        System.out.println("Final Score: " + homeTeam + " " + homeTeamScore + " - " + awayTeamScore + " " + awayTeam);
        
    }

}
public class Match {
    public static void main(String[] args){

        MatchDay match = new MatchDay("Leeds", "Spurs", 0, 0, 90);
        match.simulateMatch("Leeds", "Spurs");
    }
}
