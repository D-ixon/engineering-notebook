class Student {
    private String name;
    // constructor must have the same name as the class
    public Student(String initialName) {
        this.name = initialName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

public class sub {
    public static void main(String[] args) {
        Student s = new Student("Manim");

        System.out.println(s.getName());

        s.setName("Ludi");

        System.out.println(s.getName());
    }
}