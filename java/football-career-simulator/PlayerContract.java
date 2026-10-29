abstract class FootballContract{
    private String playerName;
    private String club;
    private int weeklyWage;
    private int contractYears;

 
    public FootballContract(String playerName, String club, int weeklyWage, int contractYears){
        this.playerName = playerName;
        this.club = club;
        this.weeklyWage = weeklyWage;
        this.contractYears = contractYears;
    }


    public String getPlayerName() {
        return playerName;
    }

    public String getClub() {
        return club;
    }

    public int getWeeklyWage() {
        return weeklyWage;
    }

    public int getContractYears() {
        return contractYears;
    }
   

    abstract int calculateTotalContractValue();

    public void displayContract(){
        System.out.println("\n Player Name: " + this.playerName);
        System.out.println(" Current Club: " + this.club);
        System.out.println(" Player's Weekly Wages: GHC" + this.weeklyWage);
        System.out.println(" Contract Duration: " + this.contractYears + " years\n");
    }
}

class StandardContract extends FootballContract{

    public StandardContract(String playerName, String club, int weeklyWage, int contractYears){
        super(playerName, club, weeklyWage, contractYears);
    }

    @Override 
    public int calculateTotalContractValue(){
        int standardContract;
        standardContract = this.getWeeklyWage() * 52 * this.getContractYears();
        return standardContract;
    }
}

class BonusContract extends FootballContract{

    private int signingBonus;

    public BonusContract(String playerName, String club, int weeklyWage, int contractYears, int signingBonus){
        super(playerName, club, weeklyWage, contractYears);
        this.signingBonus = signingBonus;
    }

    @Override 
    public int calculateTotalContractValue(){
        int bonusContract = this.getWeeklyWage() * 52 * this.getContractYears() + this.signingBonus;
        return bonusContract;
    }
}
public class PlayerContract {
    public static void main (String[] args) {

        System.out.println("=================PLAYER CONTRACT===================");

        StandardContract Contract1 = new StandardContract("Bismark", "Real Madrid", 20000, 5);
        BonusContract Contract2 = new BonusContract("Kofi", "Manchester United", 400000, 3, 7000);

        Contract1.displayContract();
        System.out.println(" GHC" + Contract1.calculateTotalContractValue());
        System.out.println(" GHC" + Contract2.calculateTotalContractValue());

    }
}
