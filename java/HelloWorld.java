import java.util.ArrayList;

class Dog {
    private String breed;
    public void setBreed(String newBreed){
        breed = newBreed;
    }

    public String getBreed() {
        return breed;
    }
}
public class HelloWorld {
    public static void main(String[] args) {

        int[] array;

        array = new int[10];

        System.out.println(array.length);

        array[0] = 1444;
        array[1] = 100;
        array[2] = 200;
        array[3] = 300;
        array[4] = 400;

        for (int i = 0; i < 5; i++){
            if (i >= 2){
                break;
            }
            System.out.println("loop");
        }
        ArrayList<Object> mixedlist = new ArrayList<>();
        mixedlist.add("Name");
        mixedlist.add(4);

        System.out.println(mixedlist.get(0));
        System.out.println(mixedlist.get(1));
        System.out.println(array[0]);
        for (int el : array) {
            System.out.println(el);
        }
        Dog myDog = new Dog();
        
        // We use the setter method to set the breed
        myDog.setBreed("Golden Retriever");
        
        // We use the getter method to read it back
        System.out.println(myDog.getBreed()); 

        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
        }

    }
}
