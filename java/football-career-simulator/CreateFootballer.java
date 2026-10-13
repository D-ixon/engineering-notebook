class FootballPlayer {

    String name;
    String position;
    String club;
    int age;
    int overall; 
    int pace;
    int shooting;
    int passing;
    int stamina;

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
        double skill1 = kofi.calculateAverageSkill();
        System.out.println("Average Skill: " + skill1 + "\n");
        kofi.playerStatus();

        dickson.displayProfile();
        double skill2 = dickson.calculateAverageSkill();
        System.out.println("Average Skill: " + skill2 + "\n");
        dickson.playerStatus();

        kofaie.displayProfile();
        double skill3 = kofaie.calculateAverageSkill();
        System.out.println("Average Skill: " + skill3 + "\n");
        kofaie.playerStatus();

        System.out.println("=".repeat(8) + "PLAYER COMPARISON" + "=".repeat(8));

        // Find the best player
        double largest = skill1;
        if (skill2 > skill1){
            largest = skill2;
        }if (skill3 > largest){
            largest = skill3;
        }if (kofi.calculateAverageSkill() == largest){
            System.out.println("Best Player: " + kofi.name);
        }else if (dickson.calculateAverageSkill() == largest){
            System.out.println("Best Player: " + dickson.name);
        }else if (kofaie.calculateAverageSkill() == largest){
            System.out.println("Best Player: " + kofaie.name);
        }
        System.out.println("Highest Average Skill: " + largest);
    }
}