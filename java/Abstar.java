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

interface Animals{
    boolean feed(boolean timeToEat);
    void groom();
    void pet();

}

class Cat implements Animals{
    public boolean feed(boolean timeToEat){
        return true;
    }
    @Override 
    public void groom(){
        System.out.println("Grooming");
    }

    @Override
    public void pet(){
        System.out.println("Petting");
    }
}
public class Abstar {
    public static void main(String[] args) {
        dog myDog = new dog();
        myDog.makeSound();

        myDog.sleep();
    }

}
