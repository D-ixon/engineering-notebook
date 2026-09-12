import java.util.Arrays;

public class sum {
    public static void main(String[] args){
        int[] digits = new int[]{2, 4, 47, 9, 939, 90, 2, 77, 9, 0, 27, 7, 34, 0, 24, 10};
        int target = 34;

        for (int i = 0; i < digits.length; i++){
            for (int j = i + 1; j < digits.length; j++){
                if (digits[i] + digits[j] == target){
                    System.out.println("Found match at indices: " + Arrays.toString(new int[]{i, j}));
                    return; // Exits main method immediately after finding the first match
                }
            }
        }
        System.out.println("No pair found.");
    }
}