import java.util.Scanner;

class Player{
    private String name;
    private String position;
    private String club;
    private int age;
    private int overall;
    private int shooting;
    private int pace;
    private int passing;
    private int stamina;

    public Player(String name, String position, String club, int age, int overall, int shooting, int pace, int passing, int stamina){
        this.name = name;
        this.position = position;
        this.club = club;
        this.age = age;
        this.overall = overall;
        this.shooting = shooting;
        this.pace = pace;
        this.passing = passing;
        this.stamina = stamina;
    }

    // Default constructor
    public Player(){}

    // Getter
    public String getName(){
        return this.name;
    }
    // Setter for name field
    public void setName(String name){
        this.name = name;
    }
    // Setter for position field
    public void setPosition(String position){
        this.position = position;
    }
    // Setter for club name
    public void setClubName(String club){
        this.club = club;
    }
    // Setter for age
    public void setAge(int age){
        this.age = age;
    }
    // Setter for overall
    public void setOverall(int overall){
        this.overall = overall;
    }
    // Setter for shooting
    public void setShooting(int shooting){
        this.shooting = shooting;
    }
    // setter for pace 
    public void setPace(int pace){
        this.pace = pace;
    }
    // setter for passing
    public void setPassing(int passing){
        this.passing = passing;
    }
    // setter for stamina
    public void setStamina(int stamina){
        this.stamina = stamina;
    }

    // Calculate player's average skill
    public double calculateAverageSkill() {
        return (this.pace + this.shooting + this.passing + this.stamina) / 4.0;
    }
    // Train player's shooting
    public int trainShooting(){
        this.shooting += 2;
        return this.shooting;
    }
    // Train player's pace
    public int trainPace(){
        this.pace += 2;
        return this.pace;
    }
    // Train player's passing
    public int trainPassing(){
        this.passing += 2;
        return this.passing;
    }
    // Train player's stamina
    public int trainStamina(){
        this.stamina += 2;
        return this.stamina;
    }

    public int playerOverall(){
        this.overall = (this.pace + this.shooting + this.passing + this.stamina) / 4;
        return this.overall;
    }

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
}

public class PlayerTrainer {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(8) + "Welcome To Training Lad!" + "=".repeat(8));
        Scanner scanner = new Scanner(System.in);

        // Define an initial player
        Player kofi = new Player("Kofi", "LW", "Real Madrid",
        21,78, 70, 78, 79, 72);

        Player kofaie = new Player();
        System.out.print("Enter your football name: ");
        kofaie.setName(scanner.nextLine());
        
        System.out.print("Enter your age: ");
        kofaie.setAge(scanner.nextInt());
        
        System.out.print("Enter your club ");
        kofaie.setClubName(scanner.nextLine());

        System.out.print("Enter your position: ");
        kofaie.setPosition(scanner.nextLine());
        
        System.out.print("Enter your overall: ");
        kofaie.setOverall(scanner.nextInt());

        System.out.print("Enter your pace: ");
        kofaie.setPace(scanner.nextInt());

        System.out.print("Enter your shooting: ");
        kofaie.setShooting(scanner.nextInt());

        System.out.print("Enter your passing: ");
        kofaie.setPassing(scanner.nextInt());

        System.out.print("Enter your stamina: ");
        kofaie.setStamina(scanner.nextInt());


        System.out.println("=".repeat(30));

        System.out.println(kofi.playerOverall());
    }
}
