class FootballPlayer{

    String name, position, club;
    int age, overall, pace, shooting, passing, stamina;

    public FootballPlayer(String name, String position, String club, int age, int overall, int pace, int shooting, int passing, int stamina) {
        this.name = name;
        this.position = position;
        this.club = club;
        this.age = age;
        this.overall = overall;
        this.pace = pace;
        this.shooting = shooting;
        this.passing = passing;
        this.stamina = stamina;  
    }

    public void displayProfile(String name, String position, String club, int age, int overall, int pace, int shooting, int passing, int stamina){
        System.out.println(name + "\n" + position + "\n" + club + "\n" + age + "\n" + overall + "\n" + pace + "\n" + shooting + "\n" + passing + "\n" + stamina);
    }

    public double calculateAverageSkill(int pace, int shooting, int passing, int stamina){
        double sum = pace + shooting + passing + stamina;
        double average = sum / 4;

        return average;
    }
}

public class CreateFootballer {
    public static void main(String[] args) {
        System.out.println("=".repeat(8) + " PLAYER PROFILE " + "=".repeat(8));

        FootballPlayer Kofi = new FootballPlayer("Kofi", "LW", "Manchester United", 
        21, 82, 85, 78, 85, 75);

        FootballPlayer Dickson = new FootballPlayer("Dickson", "AM", "Manchester United", 
        21, 83, 85, 78, 92, 75);

        FootballPlayer Kofaie = new FootballPlayer("Kofaie", "CB", "Manchester United", 
        21, 91, 85, 68, 85, 79);

        double KofiAverage = Kofi.calculateAverageSkill(85, 78, 85, 75); 


    }
}
