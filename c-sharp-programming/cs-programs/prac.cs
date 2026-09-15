using System;
using System.Collections.Generic;
using System.Linq;

// =========================================================
// PILLAR: ABSTRACTION
// "Person" is a blueprint. You can NEVER write "new Person()".
// It only exists so other classes can inherit from it.
// It forces every child class to implement DisplayInfo().
// =========================================================
public abstract class Person
{
    // These two properties are shared by ANY kind of person
    // (Student, Teacher, GraduateStudent, etc.)
    public int Id { get; set; }

    // PILLAR: ENCAPSULATION
    // We don't just expose a raw field. We use a property with
    // a private backing field (_name) and add validation in the setter.
    private string _name = "";

    public string Name
    {
        get { return _name; }
        set
        {
            if (string.IsNullOrWhiteSpace(value))
            {
                Console.WriteLine("Rejected: Name cannot be empty.");
                // we simply don't update _name -- invalid value is ignored
            }
            else
            {
                _name = value;
            }
        }
    }

    // No body here -- just a signature ending in ";"
    // This is a PROMISE: "every class that inherits from Person
    // MUST provide its own version of this method."
    public abstract void DisplayInfo();
}

// =========================================================
// PILLAR: INHERITANCE
// Student inherits Id and Name from Person for free (the colon does this).
// It only needs to add what's NEW: Age.
// =========================================================
public class Student : Person
{
    // ENCAPSULATION again: Age is validated in its setter.
    private int _age;

    public int Age
    {
        get { return _age; }
        set
        {
            if (value < 16 || value > 100)
            {
                Console.WriteLine($"Rejected: Age {value} is invalid (must be 16-100).");
                // invalid value ignored, _age keeps its old value
            }
            else
            {
                _age = value;
            }
        }
    }

    // PILLAR: POLYMORPHISM
    // "override" fulfills the promise made by Person's abstract method.
    public override void DisplayInfo()
    {
        Console.WriteLine($"[Student] Id: {Id}, Name: {Name}, Age: {Age}");
    }
}

// =========================================================
// INHERITANCE (one level deeper): GraduateStudent inherits from Student,
// which itself inherits from Person. So GraduateStudent gets
// Id, Name (from Person) AND Age (from Student) for free.
// =========================================================
public class GraduateStudent : Student
{
    public string ThesisTitle { get; set; } = "";

    // POLYMORPHISM again: overriding a SECOND time, further down the chain.
    public override void DisplayInfo()
    {
        // "base.DisplayInfo()" runs Student's version first (prints Id/Name/Age)
        base.DisplayInfo();
        // then we add our own extra line on top
        Console.WriteLine($"           Thesis: {ThesisTitle}");
    }
}

// =========================================================
// Program: holds the in-memory list and CRUD methods
// =========================================================
public class Program
{
    // The in-memory "database" -- just a List<Student> living in RAM.
    // Nothing here is saved to disk; when the program ends, it's gone.
    private static List<Student> students = new();

    // ---------------- CREATE ----------------
    public static void AddStudent(Student s)
    {
        students.Add(s);
        Console.WriteLine($"Added student Id={s.Id}, Name={s.Name}");
    }

    // ---------------- READ ----------------
    public static Student? FindStudent(int id)
    {
        // FirstOrDefault scans the list and returns the first match,
        // or null (default for a reference type) if nothing matches.
        return students.FirstOrDefault(s => s.Id == id);
    }

    // ---------------- UPDATE ----------------
    public static void UpdateStudentAge(int id, int newAge)
    {
        Student? existing = FindStudent(id);
        if (existing == null)
        {
            Console.WriteLine($"Update failed: no student with Id={id}");
            return;
        }
        // Setting .Age goes THROUGH the property setter above,
        // so validation (16-100) still applies here automatically.
        existing.Age = newAge;
        Console.WriteLine($"Updated Id={id} -> Age is now {existing.Age}");
    }

    // ---------------- DELETE ----------------
    public static void DeleteStudent(int id)
    {
        int removedCount = students.RemoveAll(s => s.Id == id);
        Console.WriteLine(removedCount > 0
            ? $"Deleted student Id={id}"
            : $"Delete failed: no student with Id={id}");
    }

    // ---------------- Helper to print everyone ----------------
    public static void PrintAllStudents()
    {
        Console.WriteLine("---- Current Student List ----");
        foreach (Student s in students)
        {
            s.DisplayInfo(); // polymorphism: runs Student's or GraduateStudent's version
        }
        Console.WriteLine("-------------------------------");
    }

    public static void Main()
    {
        Console.WriteLine("=== Adding students ===");

        Student s1 = new Student { Id = 1, Name = "Ama", Age = 20 };
        AddStudent(s1);

        GraduateStudent s2 = new GraduateStudent
        {
            Id = 2,
            Name = "Kwame",
            Age = 24,
            ThesisTitle = "Drone Swarm Coordination"
        };
        AddStudent(s2); // note: GraduateStudent IS a Student, so this is allowed

        Console.WriteLine("\n=== Trying to add an invalid student (bad age) ===");
        Student s3 = new Student { Id = 3, Name = "Yaw", Age = 12 }; // rejected inside setter
        AddStudent(s3); // still added to the list, but Age stayed at 0 (default int)

        Console.WriteLine("\n=== Printing all students (polymorphism in action) ===");
        PrintAllStudents();

        Console.WriteLine("\n=== Updating student 1's age ===");
        UpdateStudentAge(1, 21);

        Console.WriteLine("\n=== Deleting student 3 ===");
        DeleteStudent(3);

        Console.WriteLine("\n=== Final list ===");
        PrintAllStudents();
    }
}