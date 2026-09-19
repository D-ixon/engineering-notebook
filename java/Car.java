public class Car {
    String brand;
    int year;

    // 2. Constructor: Used to initialize the object's data when created
    public Car(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // 3. Method: A behavior or action the Car object can perform
    public void displayDetails() {
        System.out.println("Car Brand: " + brand + ", Year: " + year);
    }

    // 4. Main method to demonstrate creating objects
    public static void main(String[] args) {
        // Create the first Car object using the 'new' keyword
        Car car1 = new Car("Toyota", 2024);
        
        // Create a second Car object with different data
        Car car2 = new Car("Tesla", 2026);

        // Use the objects to call their methods
        car1.displayDetails(); // Outputs: Car Brand: Toyota, Year: 2024
        car2.displayDetails(); // Outputs: Car Brand: Tesla, Year: 2026
    }
}
