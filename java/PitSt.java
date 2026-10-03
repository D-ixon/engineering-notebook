public class PitSt {
    public static void main(String[] args) {
        int[] pitStops = {7, 8, 1, 2, 3};

        // finding the fastest pit stop
        int firstindex = 0;

        for (int i = 1; i < pitStops.length; i++) {
            if (pitStops[i] < pitStops[firstindex]) {
                firstindex = i;
            }
        }
        System.out.println("The fastest pit stop time is: " + pitStops[firstindex] + " seconds");

        
    }
}