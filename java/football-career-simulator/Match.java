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

    Tracker[] track = new Tracker[4];
    track[0] = new Tracker("Anthony", "LW", "Leeds", 21, 77, 78, 78, 80);
    track[1] = new Tracker("Williams", "LW", "Leeds", 29, 97, 78, 78, 80);
    track[2] = new Tracker("Jake", "ST", "Spurs", 24, 79, 78, 78, 80);
    track[3] = new Tracker("Green", "DM", "Spurs", 21, 77, 78, 78, 80);

    Random rand = new Random();

    for (int minute = 1; minute < matchDuration; minute++) {

        int eventChance = rand.nextInt(100);

        if (eventChance < 3) {
            boolean isHomeGoal = rand.nextBoolean();
            String scoringTeam;

            if (isHomeGoal) {
                this.homeTeamScore++;
                scoringTeam = this.homeTeam;
            } else {
                this.awayTeamScore++;
                scoringTeam = this.awayTeam;
            }

            // 1. Collect all players from the scoring team
            List<Tracker> eligibleScorers = new ArrayList<>();
            for (Tracker player : track) {
                if (player.getClub().equals(scoringTeam)) {
                    eligibleScorers.add(player);
                }
            }

            // 2. Pick ONE random player from that team to score
            if (!eligibleScorers.isEmpty()) {
                Tracker scorer = eligibleScorers.get(rand.nextInt(eligibleScorers.size()));

                System.out.println(minute + "' - Goal! " + scorer.getName() + " (" + scoringTeam + ") "
                        + this.homeTeam + " " + this.homeTeamScore + " - "
                        + this.awayTeam + " " + this.awayTeamScore);
            } else {
                // Fallback if no players in 'track' belong to scoringTeam
                System.out.println(minute + "' - Goal! " + this.homeTeam + " " + this.homeTeamScore + " - "
                        + this.awayTeam + " " + this.awayTeamScore);
            }

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
