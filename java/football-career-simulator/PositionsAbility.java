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
    @SuppressWarnings("OverridableMethodCallInConstructor")
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

    public void performSpecialAbility() {
        System.out.println("Performing special ability");
    }
}

class Striker extends Player{
    public Striker(String name, String position, String club, int age, int shooting, int pace, int passing, int stamina){
        super(name, position, club, age, shooting, pace, passing, stamina);
    }

    @Override 
    public void performSpecialAbility(){
        System.out.println(" Ooooooo what a shot ");
    }
}

class Midfielder extends Player{
    public Midfielder(String name, String position, String club, int age, int shooting, int pace, int passing, int stamina){
        super(name, position, club, age, shooting, pace, passing, stamina);
    }

    @Override 
    public void performSpecialAbility(){
        System.out.println(" What a line-breaking pass");
    }
}

class GoalKeeper extends Player{
    public GoalKeeper(String name, String position, String club, int age, int shooting, int pace, int passing, int stamina){
        super(name, position, club, age, shooting, pace, passing, stamina);
    }

    @Override
    public void performSpecialAbility(){
        System.out.println(" spectacular diving save");
    }
}


public class PositionsAbility{
    public static void main(String[] args){

        Player[] players = {new Striker("Kane", "ST", "Real Madrid", 23, 89, 78, 82, 88), 
            new Midfielder("Ader Guller", "AM", "Real Madrid", 21, 81, 82, 89, 85), 
            new GoalKeeper("Courtois", "GK", "Real Madrid", 32, 72, 52, 78, 88)
        };
        
        for (Player player : players){
            player.performSpecialAbility();
        }
        
    }
}

