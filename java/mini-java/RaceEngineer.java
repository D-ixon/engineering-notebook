public class RaceEngineer {

    public static double getFastestLap(int a, double[] arr){
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[a]){
                a = i;
            }
        }
        return a;
    }

    public static double getSlowestLap(double a){
        return 0;
    }

    public static double getAverageLap(double a){
        return 0;
    }

    public static int countFastLaps(int a){
        return 0;
    }

    public static int countSlowLaps(int a){
        return 0;
    }

    public static void main(String[] args) {
        double[] lapTimes = {
            91.2, 89.5, 88.7, 87.9,
            87.2, 86.8, 87.1, 88.0,
            89.3, 90.1
        };

        System.out.println("\n" + "=".repeat(8) + " RACE REPORT " + "=".repeat(8) + "\n");
        System.out.println(" Total Laps: " + lapTimes.length);

    }
}
