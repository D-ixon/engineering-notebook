public class ChampionshipCalc {

    public static int getPoints(int position) {
        return switch (position) {
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

        int[] positions = {1, 3, 2};
        int totalPoints = 0;

        for (int i = 0; i < positions.length; i++) {
            int points = getPoints(positions[i]);

            System.out.println(
                "Race " + (i + 1) + ": " + points + " points"
            );

            totalPoints += points;
        }

        System.out.println();
        System.out.println("Championship points: " + totalPoints);
    }
}

