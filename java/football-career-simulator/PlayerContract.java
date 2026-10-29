abstract class FootballContract{
    private String playerName;
    private String club;
    private double weeklyWage;
    private double contractYears;

 
    public FootballContract(String playerName, String club, double weeklyWage, int contractYears){
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

    public double getWeeklyWage() {
        return weeklyWage;
    }

    public double getContractYears() {
        return contractYears;
    }
   

    abstract double calculateTotalContractValue();

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
    public double  calculateTotalContractValue(){
        double standardContract = this.getWeeklyWage() * 52 * this.getContractYears();
        return standardContract;
    }
}

class BonusContract extends FootballContract{

    private double signingBonus;

    public BonusContract(String playerName, String club, int weeklyWage, int contractYears, int signingBonus){
        super(playerName, club, weeklyWage, contractYears);
        this.signingBonus = signingBonus;
    }

    @Override 
    public double calculateTotalContractValue(){
        double bonusContract = this.getWeeklyWage() * 52 * this.getContractYears() + this.signingBonus;
        return bonusContract;
    }
}
public class PlayerContract {
    public static void main (String[] args) {

        System.out.println("=================PLAYER CONTRACT===================");

        StandardContract Contract1 = new StandardContract("Bismark", "Real Madrid", 20000, 5);
        BonusContract Contract2 = new BonusContract("Kofi", "Manchester United", 400000, 3, 
        70);

        Contract1.displayContract();
        System.out.printf(" Standard contract GHC %,.2f%n", Contract1.calculateTotalContractValue());

        Contract2.displayContract();
        System.out.printf("Contract Plus Signing Bonus GHC %,.2f%n", Contract2.calculateTotalContractValue());

    }
}
