public class Formula12 {
    public static void main(String[] args) {
        double[] laps = {87.5, 86.9, 87.1, 86.4, 87.0};

        double fastest = laps[0];

        for (int i = 1; i < laps.length; i++) {
            if (laps[i] < fastest) {
                fastest = laps[i];
            }
        }
        System.out.println("The fastest lap was " + fastest);
    }
}
