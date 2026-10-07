// Parent class
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + "is eating");
    }
}

class Dog extends Animal {
    String breed;
        
    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }

    public void bark() {
        System.out.println(name + " says: Woof!");
    }

    @Override 
    public void eat() {
        System.out.println(name + " the " + breed + " munches on kibble.");
    }
}

public class Door {
    public static void main(String[] args) {
        Dog myDog = new Dog("Buddy", "Golden Retriever");

        myDog.eat();
        
        myDog.bark();
    }
}   
