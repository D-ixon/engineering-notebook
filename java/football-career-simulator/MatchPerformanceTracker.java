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

class Tracker extends Player {
    private int appearances = 0;
    private int goals = 0;
    private int assists = 0;
    private double[] matchRatings = new double[38];

    // Child Constructor
    public Tracker(String name, String position, String club, int age, int shooting, int pace, int passing, int stamina){
        super(name, position, club, age, shooting, pace, passing, stamina);
    }

    public void playMatch(int goals, int assists, double ratings){
        if (goals >= 0 && assists >= 0 && (ratings >= 0.0 && ratings <= 10.0) && appearances < 38){
            
            matchRatings[appearances] = ratings;
            
            this.appearances += 1;
            this.goals += goals;   
            this.assists += assists; 
        }
    }

    // Getters
    public int getGoals(){
        return this.goals;
    }
    public int getAssists(){
        return this.assists;
    }
    public int getAppearances(){
        return this.appearances;
    }
    public double getGoalsPerAppearance(){
        double GPA = 0;
        if (getAppearances() > 0){
            GPA = (double) getGoals() / getAppearances();
        }
        return GPA;
    }
    
    public double calculateAverageRating(){
        if (getAppearances() == 0) {
            return 0.0;
        }

        double sum = 0.0;
        for (int i = 0; i < getAppearances(); i++) {
            sum += matchRatings[i];
        }
        return sum / getAppearances();
    }

    public void displaySeasonStats(){
        System.out.println( "\n=".repeat(8) + " PLAYER SEASON STATS " + "=".repeat(8));
        System.out.println( " Name " + this.getName());
        System.out.println( " Players " + this.getAppearances());
        System.out.println( " Goals " + this.getGoals());
        System.out.println( " Goals per Appearances " + getGoalsPerAppearance());
        System.out.println( " Assists " + this.getAssists());
        System.out.println( " Average Ratings " + this.calculateAverageRating()+ "\n");
    }
}

public class MatchPerformanceTracker {
    public static void main(String[] args) {
        
        Tracker dan = new Tracker("Dan", "LW", "Real Madrid", 21, 67, 78, 67, 70);
        
        dan.playMatch(3, 1, 8.9);
        dan.playMatch(1, 0, 7.8);
        dan.playMatch(0, 1, 7.2);

        dan.displaySeasonStats();

    }
}

