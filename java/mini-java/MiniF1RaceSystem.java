public class MiniF1RaceSystem {

    public static int getPoints(int positions){
        return switch (positions){
            case 1 -> 25;
            case 2 -> 18;
            case 3 -> 15;
            case 4 -> 12;
            case 5 -> 10;
            case 6 -> 8;
            case 7 -> 6;
            case 8 -> 4;
            case 9 -> 2;
            case 10 -> 1;
            default -> 0;
        };
    }

    public static int findFastestLap(double[] arr){
        int firstIndex = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < arr[firstIndex]){
                firstIndex = i;
            }
        }
        return firstIndex;
    }

    public static int chamPoints(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum += getPoints(arr[i]);
        }
        return sum;
    }

    public static int findWinner(int[] arr){
        int firstIndex = 0;
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[firstIndex]){
                firstIndex = i;
            }
        }
        return firstIndex;
    }
    
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
        System.out.println(" " + drivers[i].toUpperCase() + "\n" + " Positions: P" + positions[i] + "\n" 
            + " Points: " + getPoints(positions[i]) + "\n" 
            + " Fastest Lap: " + fastestLaps[i] + "\n" );
    }

    System.out.println("=".repeat(40) + "\n");

    // Race Winner
    String driver = drivers[findWinner(positions)];
    System.out.println(" Race Winner: " + driver);

    // Fastest Lap
    String fastlap = drivers[findFastestLap(fastestLaps)];
    System.out.println(" Fastest Lap: " + fastlap);

    // Total Championship Points
    System.out.println(" Total Championship Points: " + chamPoints(positions));
    }
}
