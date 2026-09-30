
class Car {
    private final String name;

    public Car(String name){
        this.name = name;
    }

    public void announceSelf() {
        System.out.println("Hello, my name is " + name);
    }
}

public class Main{
    public static void main(String[] args) {
        Car s1 = new Car("Manim");
        Car s2 = new Car("Ludi");

        s1.announceSelf();
        s2.announceSelf();
    }
}