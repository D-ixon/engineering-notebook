public class Formula1 {

    public static double sum(double a, double b, double c){
        return a + b + c;
    }

    public static double mean(double a, double b, double c){
        return (a + b + c)/3;
    }

    public static void main(String[] args) {
        double lap1 = 87.5;
        double lap2 = 86.9;
        double lap3 = 87.9;

        double RaceTime = Formula1.sum(lap1, lap2, lap3);
        double AverageTime = Formula1.mean(lap1, lap2, lap3);

        System.out.println("Total race time: " + RaceTime);
        System.out.println("Average lap time: " + AverageTime);

    }
}
