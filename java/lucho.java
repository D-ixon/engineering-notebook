class Greeter {
    public static String hey(String a, String b) {
        return "Hello " + a + " and " + b;
    }
}
class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }
}
public class lucho {
    public static void main(String[] args){
        int result = Calculator.add(5, 10);
        System.out.println(result);

        String str1 = "Manim";
        String str2 = "Ludi";

        String message = Greeter.hey(str1, str2);

        System.out.println(message);
    }
}