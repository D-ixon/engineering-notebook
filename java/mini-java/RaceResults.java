public class RaceResults {
    public static void main(String[] args) {
        String[] drivers = {
            "Verstappen", 
            "Hamilton", 
            "Leclerc", 
            "Norris", 
            "Alonso"
        };
        
        int[] positions = {2, 5, 1, 3, 7};

        int firstPlaceIndex = 0;

        for (int i = 0; i < drivers.length; i++) {
            System.out.println("Driver: " + drivers[i] + " - P" + positions[i]);
        }
        for (int i = 1; i < positions.length; i++){
            if (positions[i] < positions[firstPlaceIndex]) {
                firstPlaceIndex = i;
            }
            
        }

        System.out.println("Race Winner: " + drivers[firstPlaceIndex]);
    }
}