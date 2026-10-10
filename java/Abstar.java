abstract class Animal{
    public void sleep(){
        System.out.println("we all sleep ");
    }
    public abstract void makeSound();
}

class dog extends Animal{
    @Override
    public void makeSound() {
        System.out.println("Dogs bark ");
    }

    
}

public class Abstar {
    public static void main(String[] args) {
        dog myDog = new dog();
        myDog.makeSound();

        myDog.sleep();
    }

}
