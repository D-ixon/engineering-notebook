import java.util.Scanner;

class Player {
    private String name;
    private String position;
    private String club;
    private int age;
    private int overall;
    private int shooting;
    private int pace;
    private int passing;
    private int stamina;

    // Parameterized constructor
    public Player(String name, String position, String club, int age, int shooting, int pace, int passing, int stamina) {
        this.name = name;
        this.position = position;
        this.club = club;
        setAge(age);
        setShooting(shooting);
        setPace(pace);
        setPassing(passing);
        setStamina(stamina);
        updateOverall();
    }

    // Default constructor
    public Player() {
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getPosition() {
        return this.position;
    }

    public String getClub() {
        return this.club;
    }

    public int getAge() {
        return this.age;
    }

    public int getOverall() {
        return this.overall;
    }

    public int getShooting() {
        return this.shooting;
    }

    public int getPace() {
        return this.pace;
    }

    public int getPassing() {
        return this.passing;
    }

    public int getStamina() {
        return this.stamina;
    }

    // Setters for player information
    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setClubName(String club) {
        this.club = club;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Age must be positive.");
        }
    }

    // Validate attributes between 0 and 100
    public void setShooting(int shooting) {
        if (shooting >= 0 && shooting <= 100) {
            this.shooting = shooting;
            updateOverall();
        } else {
            System.out.println("Shooting must be between 0 and 100.");
        }
    }

    public void setPace(int pace) {
        if (pace >= 0 && pace <= 100) {
            this.pace = pace;
            updateOverall();
        } else {
            System.out.println("Pace must be between 0 and 100.");
        }
    }

    public void setPassing(int passing) {
        if (passing >= 0 && passing <= 100) {
            this.passing = passing;
            updateOverall();
        } else {
            System.out.println("Passing must be between 0 and 100.");
        }
    }

    public void setStamina(int stamina) {
        if (stamina >= 0 && stamina <= 100) {
            this.stamina = stamina;
            updateOverall();
        } else {
            System.out.println("Stamina must be between 0 and 100.");
        }
    }

    // Calculate average skill
    public double calculateAverageSkill() {
        return (this.pace + this.shooting + this.passing + this.stamina) / 4.0;
    }

    // Update overall rating after attribute changes
    public int updateOverall() {
        this.overall = (int) Math.round(calculateAverageSkill());
        return this.overall;
    }

    // Training methods: increase an attribute by 2, maximum 100
    public int trainShooting() {
        this.shooting = Math.min(100, this.shooting + 2);
        updateOverall();
        return this.shooting;
    }

    public int trainPace() {
        this.pace = Math.min(100, this.pace + 2);
        updateOverall();
        return this.pace;
    }

    public int trainPassing() {
        this.passing = Math.min(100, this.passing + 2);
        updateOverall();
        return this.passing;
    }

    public int trainStamina() {
        this.stamina = Math.min(100, this.stamina + 2);
        updateOverall();
        return this.stamina;
    }

    // Display profile
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("======== WELCOME TO TRAINING, LAD! ========");

        // Player 1
        Player kofi = new Player("Kofi", "LW", "Real Madrid", 21, 70, 80,  79,
        72);

        // Player 2: created using user input
        Player kofaie = new Player();

        System.out.print("Enter your football name: ");
        kofaie.setName(scanner.nextLine());

        System.out.print("Enter your age: ");
        kofaie.setAge(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter your club: ");
        kofaie.setClubName(scanner.nextLine());

        System.out.print("Enter your position: ");
        kofaie.setPosition(scanner.nextLine());

        System.out.print("Enter your pace (0-100): ");
        kofaie.setPace(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter your shooting (0-100): ");
        kofaie.setShooting(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter your passing (0-100): ");
        kofaie.setPassing(Integer.parseInt(scanner.nextLine()));

        System.out.print("Enter your stamina (0-100): ");
        kofaie.setStamina(Integer.parseInt(scanner.nextLine()));

        // Show original profiles
        System.out.println("\n========== INITIAL PROFILES ==========");

        System.out.println("\n--- Kofi's Profile ---");
        kofi.displayProfile();

        System.out.println("\n--- " + kofaie.getName() + "'s Profile ---");
        kofaie.displayProfile();

        double kofiAverageBefore = kofi.calculateAverageSkill();
        double kofaieAverageBefore = kofaie.calculateAverageSkill();

        // Interactive training menu
        Player selectedPlayer = kofaie;
        String choice;

        do {
            System.out.println("\n========== TRAINING MENU ==========");
            System.out.println("1. Select Kofi");
            System.out.println("2. Select " + kofaie.getName());
            System.out.println("3. Train shooting");
            System.out.println("4. Train pace");
            System.out.println("5. Train passing");
            System.out.println("6. Train stamina");
            System.out.println("7. Display selected player's profile");
            System.out.println("8. Exit training");

            System.out.print("Choose an option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    selectedPlayer = kofi;
                    System.out.println("Selected Kofi.");
                }
                case "2" -> {
                    selectedPlayer = kofaie;
                    System.out.println("Selected " + kofaie.getName() + ".");
                }
                case "3" ->
                    System.out.println("New shooting: "
                            + selectedPlayer.trainShooting());
                case "4" ->
                    System.out.println("New pace: "
                            + selectedPlayer.trainPace());
                case "5" ->
                    System.out.println("New passing: "
                            + selectedPlayer.trainPassing());
                case "6" ->
                    System.out.println("New stamina: "
                            + selectedPlayer.trainStamina());
                case "7" -> selectedPlayer.displayProfile();
                case "8" -> System.out.println("Ending training session...");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (!choice.equals("8"));

        // Final profiles and comparison
        System.out.println("\n========== FINAL PROFILES ==========");

        System.out.println("\n--- Kofi's Profile ---");
        kofi.displayProfile();

        System.out.printf("Average before: %.2f%n", kofiAverageBefore);
        System.out.printf("Average after:  %.2f%n", kofi.calculateAverageSkill());

        System.out.println("\n--- " + kofaie.getName() + "'s Profile ---");
        kofaie.displayProfile();

        System.out.printf("Average before: %.2f%n", kofaieAverageBefore);
        System.out.printf("Average after:  %.2f%n", kofaie.calculateAverageSkill());

        System.out.println("\n========== TRAINING COMPLETE ==========");
        scanner.close();
    }
}
