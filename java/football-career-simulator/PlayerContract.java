abstract class FootballContract{
    String playerName;
    String club;
    int weeklyWage;
    int contractYears;

    public FootballContract(String playerName, String club, int weeklyWage, int contractYears){
        this.playerName = playerName;
        this.club = club;
        this.weeklyWage = weeklyWage;
        this.contractYears = contractYears;
    }

    abstract int calculateTotalContractValue();

    public void displayContract(){
        System.out.println("\n Player Name: " + this.playerName);
        System.out.println(" Current Club: " + this.club);
        System.out.println(" Player's Weekly Wages: " + this.weeklyWage);
        System.out.println(" Contract Duration: " + this.contractYears + "\n");
    }
}

class StandardContract extends FootballContract{

    public StandardContract(String playerName, String club, int weeklyWage, int contractYears){
        super(playerName, club, weeklyWage, contractYears);
    }

    @Override 
    int calculateTotalContractValue(){
        int standardContract;
        standardContract = this.weeklyWage * 52 * this.contractYears;
        return standardContract;
    }
}

class BonusContract extends FootballContract{

    public BonusContract(String playerName, String club, int weeklyWage, int contractYears){
        super(playerName, club, weeklyWage, contractYears);
    }

    @Override 
    int calculateTotalContractValue(){
        int signingBonus = 0; 
        int bonusContract = this.weeklyWage * 52 * this.contractYears + signingBonus;
        return bonusContract;
    }
}
public class PlayerContract {
    public static void main (String[] args) {

        System.out.println(" =================PLAYER CONTRACT===================");

    }
}
