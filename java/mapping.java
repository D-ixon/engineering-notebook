public class mapping {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 8};

        for (int i = 0; i < 5; i++){
            if (i >= 2){
                break;
            }
            System.out.println("loop");
            if (i == 3){
                continue;
            }
            System.out.println(arr[i]);
        }
        
    }
}
