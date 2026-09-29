public class tio {
    public static void main(String[] args) {
        String s1 = "Manim";
        String name = new String("Manim");

        System.out.println(s1 == name); // false, because they are different objects
        System.out.println(s1.equals(name)); // true, because they have the same content

        System.out.println("The string object contains: " + name);
    }
    


}
