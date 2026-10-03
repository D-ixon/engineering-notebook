import java.util.Scanner;

public class Formula123 {

    public static int getPoints(int positions){

        return switch (positions) {
            case 1 -> 25;
            case 2 -> 18;
            case 3 -> 15;
            case 4 -> 12;
            case 5 -> 10;
            case 6 -> 8;
            case 7 -> 6;
            case 8 -> 4;
            case 9 -> 2;
            case 10 -> 1;
            default -> 0;
        };
    }
    
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter team's current position: ");
            int position = scanner.nextInt();

            int points = Formula123.getPoints(position);

            System.out.println("Position: " + position);
            System.out.println("Points: " + points);
        }

    }
}

