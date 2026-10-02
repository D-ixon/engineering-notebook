public class PitStops {
    public static void main(String[] args) {
        double[] pitStops = {2.4, 2.7, 2.3, 3.1, 2.5};

        // finding the fastest pit stop
        int fastindex = 0;
        int slowindex = 0;
        double sum = 0.0;
        double average = 0.0;

        for (int i = 1; i < pitStops.length; i++) {
            if (pitStops[i] < pitStops[fastindex]) {
                fastindex = i;
            }
        }
        System.out.println("The fastest pit stop time is: " + pitStops[fastindex] + " seconds");

        for (int i = 1; i < pitStops.length; i++){
            if (pitStops[i] > pitStops[slowindex]){
                slowindex = i;
            }
        }
        System.out.println("The slowest pit stop time is: " + pitStops[slowindex] + " seconds");

        for (int i = 0; i < pitStops.length; i++){
            sum += pitStops[i];
        }
        average = sum/pitStops.length;
        System.out.println("The average pit stop time is: " + average + " seconds");
    }
}