abstract class Animal{
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
    }
}
