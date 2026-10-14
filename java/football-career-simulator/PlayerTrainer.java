class FootballPlayer{
    private String name;
    private String position;
    private String club;
    private int age;
    private int overall;
    private int shooting;
    private int pace;
    private int passing;
    private int stamina;

    public FootballPlayer(String name, String position, String club, int age, int overall, int shooting, int pace, int passing, int stamina){
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
    // Getter
    public String getName(){
        return this.name;
    }
    // Setter
    public void setName(String name){
        this.name = name;
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
        System.out.println("=".repeat(8) + "Player Trainer" + "=".repeat(8));

        FootballPlayer kofi = new FootballPlayer("Kofi", "LW", "Real Madrid",
        21,78, 70, 78, 79, 72);

        FootballPlayer kofaie = new FootballPlayer("Kofaie", "AM", "Manchester United", 
        21, 82, 80, 78, 75, 78);

        kofi.displayProfile();
        kofaie.displayProfile();

        
    }
}
