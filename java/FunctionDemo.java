public class FunctionDemo {

    public static void main(String[] args) {
        System.out.println("--- Program Started ---");

        // 1. Calling a simple method with no inputs and no outputs
        printGreeting();

        // 2. Calling a method that takes an input parameter
        sayHelloTo("Alice");
        sayHelloTo("Bob");

        // 3. Calling a method that returns a value (an output)
        int result = addNumbers(5, 7);
        System.out.println("The result of adding numbers is: " + result);
    }

    /**
     * 1. A basic method.
     * 'void' means it does its job but returns no value back to the main program.
     */
    public static void printGreeting() {
        System.out.println("Welcome! This message comes from inside a method.");
    }

    /**
     * 2. A method with a parameter.
     * It accepts a String variable called 'name' and uses it inside.
     */
    public static void sayHelloTo(String name) {
        System.out.println("Hello, " + name + "! Nice to meet you.");
    }

    /**
     * 3. A method with parameters AND a return value.
     * Instead of 'void', it specifies 'int', meaning it MUST send an integer back.
     */
    public static int addNumbers(int numA, int numB) {
        int sum = numA + numB;
        return sum; // This sends the answer back to whoever called it
    }
}
