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

        Random rand = new Random();
        int eventChance = rand.nextInt(100);
        
        for (int minute = 1; minute <= 90; minute++){
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

        Tracker track = new Tracker("Anthony", null, null, 0, 0, 0, 
        0, 0);
        
        MatchDay match = new MatchDay("Leeds", "Spurs", 0, 0, 90);
        match.simulateMatch("Leeds", "Spurs");
    }
}
