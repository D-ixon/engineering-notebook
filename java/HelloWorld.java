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

        int a = 5;
        int b = 10;
        int sum = a + b;
        
        if (sum > 10) {
            System.out.println("The sum is greater than 10.");
        } else {
            System.out.println("The sum is 10 or less.");
        }

        int[] array;

        array = new int[10];

        System.out.println(array.length);

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
