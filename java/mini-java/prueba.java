public class prueba {

    public static int getPoints(int positions){

        return switch (positions) {
            case 1 -> 25;
            case 2 -> 18;
            case 3 -> 15;
            default -> 0;
        };
    }
    
    public static void main(String[] args) {
        int[] positions = {1, 3, 2};

        positionsLoop:
        for (int i = 0; i < positions.length; i++){
            switch (positions[i]) {
                case 1, 2, 3 -> System.out.println("Race " + positions[i] + ": " + getPoints(positions[i]) + " points");
                default -> {
                    break positionsLoop;
                }
            }
        }

    }
}


