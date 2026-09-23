class Student{
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void printFullName() {
        System.out.println(this.firstName + " " + this.lastName);
    }

}
public class hasta {
    public static void main(String[] args) {
        Student[] students = new Student[]{
            new Student("John", "Doe"),
            new Student("Jane", "Smith"),
            new Student("Alice", "Johnson")
        };
        for (Student s : students){
            s.printFullName();
        }
    }
}
