class FootballPlayer {

    private String name;
    private String position;
    private String club;
    private int age;
    private int overall; 
    private int pace;
    private int shooting;
    private int passing;
    private int stamina;

    // Constructor
    public FootballPlayer(String name, String position, String club, int age, int overall, int pace, int shooting, int passing, int stamina) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.club = club;
        this.overall = overall;
        this.pace = pace;
        this.shooting = shooting;
        this.passing = passing;
        this.stamina = stamina;  
    }

    public String getName(){
        return this.name;
    }

    // Method to display the current player's profile
    public void displayProfile() {
        System.out.println("Name: " + this.name);
        System.out.println("Position: " + this.position);
        System.out.println("Club: " + this.club);
        System.out.println("Age: " + this.age);
        System.out.println("Overall: " + this.overall);
        System.out.println("Pace: " + this.pace);
        System.out.println("Shooting: " + this.shooting);
        System.out.println("Passing: " + this.passing);
        System.out.println("Stamina: " + this.stamina);
    }

    // Calculates average skill using the instance fields directly
    public double calculateAverageSkill() {
        return (this.pace + this.shooting + this.passing + this.stamina) / 4.0;
    }

    // Determine whether a player is promising. Determinants: age under 23, and overall rating at least 80
    public void playerStatus(){
        if (this.age < 23 && this.overall >= 80){
            System.out.println("Status: Promising Youngster\n");
        }else{
            System.out.println("Status: Not a promising youngster");
        }
    }
}

public class CreateFootballer {
    public static void main(String[] args) {
        System.out.println("\n" + "=".repeat(8) + " PLAYER PROFILE " + "=".repeat(8) + "\n");

        FootballPlayer kofi = new FootballPlayer("Kofi", "LW", "Manchester United", 21, 82, 85, 78, 85, 75);
        FootballPlayer dickson = new FootballPlayer("Dickson", "AM", "Manchester United", 21, 83, 85, 78, 92, 75);
        FootballPlayer kofaie = new FootballPlayer("Kofaie", "CB", "Manchester United", 21, 91, 85, 68, 85, 79);

        // Display player profile and average skill ratings
        kofi.displayProfile();
        double kofiSkill = kofi.calculateAverageSkill();
        System.out.println("Average Skill: " + kofiSkill + "\n");
        kofi.playerStatus();

        dickson.displayProfile();
        double dicksonSkill = dickson.calculateAverageSkill();
        System.out.println("Average Skill: " + dicksonSkill + "\n");
        dickson.playerStatus();

        kofaie.displayProfile();
        double kofaieSkill = kofaie.calculateAverageSkill();
        System.out.println("Average Skill: " + kofaieSkill + "\n");
        kofaie.playerStatus();

        System.out.println("=".repeat(8) + "PLAYER COMPARISON" + "=".repeat(8));

        // Find the best player
        double largest = kofiSkill;
        if (dicksonSkill > kofiSkill){
            largest = dicksonSkill;
        }if (kofaieSkill > largest){
            largest = kofaieSkill;

        }if (kofiSkill == largest){
            System.out.println("Best Player: " + kofi.getName());
        }else if (dicksonSkill == largest){
            System.out.println("Best Player: " + dickson.getName());
        }else if (kofaieSkill == largest){
            System.out.println("Best Player: " + kofaie.getName());
        }
        System.out.println("Highest Average Skill: " + largest);
    }
}