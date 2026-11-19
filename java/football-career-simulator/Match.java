import java.util.Random;

class MatchDay{
    String homeTeam;
    String awayTeam;
    int homeTeamScore;
    int awayTeamScore;
    int matchDuration;

    int minuteScored;
    boolean homeGoal;
    boolean awayGoal;
    int stoppageTime;


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
                    System.out.println(" Goal! " + homeTeam + homeTeamScore + "-" + awayTeam + awayTeamScore +"\n");
                }else{
                    awayTeamScore++;
                    System.out.println(" Goal! " + homeTeam + homeTeamScore + "-" + awayTeam + awayTeamScore +"\n");
                }
            } 
        }
        
    }
}
public class Match {
    public static void main(String[] args){

    }
}
