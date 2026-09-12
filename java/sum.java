public class sum {
    public static void main(String[] args){
        int[] digits;
        digits = new int[]{2, 4, 47, 9, 939, 90, 2, 77, 9, 0, 27, 7};

        int target = 34;

        for (int i = 0; i < digits.length; i++){
            for (int j = i + 1; j < digits.length; j++){

                if (digits[i] + digits[j] == target){
                    System.out.println("Found matcing indices " + i + " and " + j + " gives you the target value");
                    System.out.println("Values at the indices are " + digits[i] + " and " + digits[j]);
                }
            }
        }
    }

}
