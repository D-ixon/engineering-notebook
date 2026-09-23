public class lucho {
    public static void land(Student s1, Student s2) {
        s1.setName("Alice");
        s2.setName("Bob");
    }
    public static void main(String[] args) {
        Student joe = new Student("Joe");
        Student bob = new Student("Bob");
        land(joe, bob);
        System.out.println("Student 1: " + joe.getName());
        System.out.println("Student 2: " + bob.getName());
    }

}
