public class MiniF1RaceSystem {
    
    public static void main(String[] args) {

        String[] drivers = {
        "Verstappen",
        "Hamilton",
        "Leclerc",
        "Norris",
        "Alonso"
    };

    int[] positions = {1, 4, 2, 3, 5};

    double[] fastestLaps = {
        85.4,
        86.1,
        85.8,
        86.0,
        87.2
    };

    System.out.println("\n" + "=".repeat(5) + " FORMULA 1 RACE REPORT " + "=".repeat(5) + "\n");

    for (int i = 0; i < drivers.length; i++){
        System.out.println(drivers[i]);
    }

    }
}
