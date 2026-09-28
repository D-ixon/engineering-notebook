class Greeter {
    public static String hey(String a, String b) {
        return "Hello " + a + " and " + b;
    }
}
class Two {
    public static void you(String c, String d){
        String formattedC = c.toUpperCase();
        String formattedD = d.toUpperCase();

        String finalMessage = "Hello " + formattedC + " and " + formattedD;

        System.out.println(finalMessage);
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

        Two.you(str1, str2);

        String message = Greeter.hey(str1, str2);

        System.out.println(message);
    }
}