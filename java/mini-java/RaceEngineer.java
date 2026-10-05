public class RaceEngineer {

    public static double getFastestLap(int a, double[] arr){
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < arr[a]){
                a = i;
            }
        }
        return arr[a];
    }

    public static double getSlowestLap(int a, double[] arr){
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > arr[a]){
                a = i;
            }
        }
        return arr[a];
    }

    public static double getAverageLap(double sum, double[] arr){
        for (int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        return sum / arr.length;
    }

    public static int countFastLaps(int a, double[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 88){
                a += 1;
            }
        }
        return a;
    }

    public static int countSlowLaps(int a, double[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] > 90){
                a += 1;
            }
        }
        return a;
    }

    public static void main(String[] args) {

        int fastestIndex = 0;
        int slowIndex = 0;
        double averageLap = 0.0;
        int countsUnder = 0;
        int countOver = 0;

        double[] lapTimes = {
            91.2, 89.5, 88.7, 87.9,
            87.2, 86.8, 87.1, 88.0,
            89.3, 90.1
        };
        // Top bar setup
        System.out.println("\n" + "=".repeat(8) + " RACE REPORT " + "=".repeat(8) + "\n");

        // Total lap time
        System.out.println(" Total Laps: " + lapTimes.length);

        // The fastest lap time
        double fastestLap = getFastestLap(fastestIndex, lapTimes);
        System.out.println(" Fastest Lap: " + fastestLap + " seconds");

        // The slowest lap time
        double slowestLap = getSlowestLap(slowIndex, lapTimes);
        System.out.println(" Slowest Lap: " + slowestLap + " seconds");

        // The average lap time
        double average = getAverageLap(averageLap, lapTimes);
        System.out.println(" Average Lap: " + average + " seconds"+ "\n");

        // Laps under 88 seconds
        int lapUnder88 = countFastLaps(countsUnder, lapTimes);
        System.out.println(" Laps under 88 seconds: " + lapUnder88);

        // Laps under 98 seconds
        int lapOver90 = countSlowLaps(countOver, lapTimes);
        System.out.println(" Laps under 90 seconds: " + lapOver90 + "\n");

        
        System.out.println(" Race Status ");
        if (average < 88.0){
            System.out.println(" Excellent pace ");
        }else if(average >= 88 && average <= 90){
            System.out.println(" Competitive pace ");
        }else if(average > 90){
            System.out.println(" Poor Pace ");
        }
    }
}
