import java.util.Scanner;

class States {

    public double[] roller(double cash) {
        double[] store = new double[10]; 
        store[0] = cash; 
        
        for (int i = 1; i < store.length; i++) {
            store[i] = store[i - 1] * 1.5;
        }
        
        return store;
    }
}

public class rollover {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        States roll = new States();

        Scanner rollScan = new Scanner(System.in);
        System.out.print("Enter starting cash point: ");
        double userCash = rollScan.nextDouble();

        double[] results = roll.roller(userCash);
        
        System.out.println("\n--- Rollover Schedule ---");
        for (int i = 0; i < results.length; i++) {
            System.out.printf("Step %d: %.2f\n", i, results[i]);
        }
        
        rollScan.close();
    }
}
