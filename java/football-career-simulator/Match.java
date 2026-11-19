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

    public void simulateMatch(boolean yesHome, boolean yesAway, int munite, String goalScorer, String goalAsister){

        System.out.println("And its show Time!");

        if (homeGoal = yesHome){
            this.homeTeamScore += 1;
            System.out.println(" Goal For " + this.homeTeam + "in the " + munite 
            + "beautiful assist by " + goalAsister + " and " + goalScorer + "nets it in");
        }else if (awayGoal = yesAway){
            this.awayTeamScore += 1;
            System.out.println(" Goal For " + this.awayTeam + "in the " + munite + "beautiful assist by " + goalAsister + " and " + goalScorer + "nets it in");
        }
        
    }
}
public class Match {
    public static void main(String[] args){

    }
}
