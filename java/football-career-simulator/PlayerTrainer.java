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
        if (this.shooting <= 100){
            this.shooting += 2;
        }  
        return this.shooting;
    }
    // Train player's pace
    public int trainPace(){
        if (this.pace <= 100){
            this.pace += 2;
        }
        return this.pace;
    }
    // Train player's passing
    public int trainPassing(){
        if (this.passing <= 100){
            this.passing += 2;
        }
        return this.passing;
    }
    // Train player's stamina
    public int trainStamina(){
        if (this.stamina <= 100){
            this.stamina += 2;
        }
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

        System.out.println("=".repeat(50));

        System.out.println(" Your Complete Profile");
        kofaie.displayProfile();

        System.out.println( " Kofaie's Averagae skill before training" + kofaie.calculateAverageSkill());

        // training drills 
        System.out.print(" Ready for today's drill? (Y/N): ");
        scanner.nextLine();               
        String yes = scanner.nextLine();    

        while (yes.equalsIgnoreCase("Y")) {
    
            System.out.println("\nChoose a training drill:");
            System.out.println(" Enter SH for a shooting drill");
            System.out.println(" Enter PA for a passing drill");
            System.out.println(" Enter PC for a pacing drill");
            System.out.println(" Enter ST for a stamina drill");
            System.out.print(" Your choice: ");
    
            // Read the drill choice here
            String drill = scanner.nextLine();

            // Process the drill choice using your switch expression
            switch (drill.toUpperCase()) {
                case "SH" -> System.out.println(kofaie.trainShooting());
                case "PA" -> System.out.println(kofaie.trainPassing());
                case "PC" -> System.out.println(kofaie.trainPace());
                case "ST" -> System.out.println(kofaie.trainStamina());
                default  -> System.out.println(" Invalid drill code. No training completed.");
    
            }

            // Ask them again if they want to do *another* drill
            System.out.print("\n Do you want to choose another drill? (Y/N): ");
            yes = scanner.nextLine();   
        }

        System.out.println( " Kofaie's Averagae skill After training" + kofaie.calculateAverageSkill());

        // This runs as soon as they type "N" or anything else to quit
        System.out.println(" Exiting program... Goodbye!");

        System.out.println(" Kofi's Overall: " + kofi.playerOverall());
        System.out.println(" Kofaie's Overall: " + kofaie.playerOverall());
    }
}