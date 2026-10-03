public class RaceSimulation {
    
    public static void main(String[] args) {
        int sumRaceTime = 0;
        int fastIndex = 0;
        int slowIndex = 0;
        int averageLap;

        System.out.println("=".repeat(30)+ "\n");

        
        // All race lap times.
        double[] lapTimes = {
            90, 88, 87, 86, 89, 
            91, 85, 87, 86, 88
        };

        // The total race time.
        for (int i = 0; i < lapTimes.length; i++){
            sumRaceTime += lapTimes[i];
        }
        System.out.println(" Total Race Time: " + sumRaceTime + " seconds");

        // The fastet lap
        for (int j = 1; j < lapTimes.length; j++){
            if (lapTimes[j] < lapTimes[fastIndex]){
                fastIndex = j;
            }
        }
        System.out.println(" Fastest lap: " + lapTimes[fastIndex]);

        // The slowest lap
        for (int a = 1; a < lapTimes.length; a++){
            if (lapTimes[a] > lapTimes[slowIndex]){
                slowIndex = a;
            }
        }
        System.out.println(" Slowest lap: " + lapTimes[slowIndex]);

        // The Average lap
        averageLap = sumRaceTime / lapTimes.length;
        System.out.println(" Average lap: " + averageLap);
    }
}
