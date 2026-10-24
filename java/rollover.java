import java.util.Scanner;

class States{

    public double roller(double cash){
        double[] store = {cash};
        int i;

        for (i = 0; i < 10; i++) {
            store[i + 1] = store[i] * 1.5;
        }

        
        
        return store[i];
    }
}
public class rollover{
    public static void main(String[] args) {
        States roll = new States();

        double userCash; 
        Scanner rollScan = new Scanner(System.in);
        System.out.print(" Enter starting cash point: ");
        userCash = rollScan.nextDouble();


        System.out.println(" " + roll.roller(userCash));
    }
}