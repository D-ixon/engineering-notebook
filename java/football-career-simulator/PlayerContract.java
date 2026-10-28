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
        return 0;
    }
}

class BonusContract extends FootballContract{

    public BonusContract(String playerName, String club, int weeklyWage, int contractYears){
        super(playerName, club, weeklyWage, contractYears);
    }

    @Override 
    int calculateTotalContractValue(){
        return 0;
    }
}
public class PlayerContract {
    public static void main (String[] args) {

    }
}
