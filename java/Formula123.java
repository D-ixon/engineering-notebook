import java.util.Scanner;

public class Formula123 {

    public static int getPoints(int positions){

        if (positions == 1){
            return 25;
        }else if (positions == 2){
            return 18;
        }else if (positions == 3){
            return 15;
        }else if (positions == 4){
            return 12;
        }else if (positions == 5){
            return 10;
        }else if (positions == 6){
            return 8;
        }else if (positions == 7){
            return 6;
        }else if (positions == 8){
            return 4;
        }else if (positions == 9){
            return 2;
        }else if (positions == 10){
            return 1;
        }else{
            return 0;
        }
    }
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter team's current position: ");
        int position = scanner.nextInt();

        int points = Formula123.getPoints(position);

        System.out.println("Position: " + position);
        System.out.println("Points: " + points);

    }
}

