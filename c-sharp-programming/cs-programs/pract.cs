using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;

// ===== MODEL =====
public class Student
{
    public int Id { get; set; }

    [Required(ErrorMessage = "Name is required")]
    [StringLength(50, ErrorMessage = "Name cannot exceed 50 characters")]
    public string Name { get; set; } = "";

    [Range(16, 100, ErrorMessage = "Enter a valid age between 16 and 100")]
    public int Age { get; set; }

    [Required(ErrorMessage = "Email is required")]
    [EmailAddress(ErrorMessage = "Enter a valid email address")]
    public string Email { get; set; } = "";
}

public class Program
{
    // In-memory "database" -- everything lives here, nothing persisted.
    private static List<Student> students = new();
    private static int nextId = 1;

    public static void Main()
    {
        Console.WriteLine("=== CREATE ===");
        var s1 = new Student { Name = "Ama", Age = 20, Email = "ama@example.com" };
        AddStudent(s1);

        var s2 = new Student { Name = "Kwame", Age = 24, Email = "kwame@example.com" };
        AddStudent(s2);

        // Invalid: bad email format, age too low
        var badStudent = new Student { Name = "", Age = 10, Email = "not-an-email" };
        AddStudent(badStudent); // will be rejected by validation, printed below

        Console.WriteLine("\n=== READ (all) ===");
        PrintAllStudents();

        Console.WriteLine("\n=== READ (by id) ===");
        FindAndPrint(1);
        FindAndPrint(99); // not found case

        Console.WriteLine("\n=== UPDATE ===");
        UpdateStudent(1, newName: "Ama Boateng", newAge: 21, newEmail: "ama.b@example.com");
        UpdateStudent(2, newName: "Kwame", newAge: 5, newEmail: "kwame@example.com"); // invalid age, rejected

        Console.WriteLine("\n=== READ (all, after update) ===");
        PrintAllStudents();

        Console.WriteLine("\n=== DELETE ===");
        DeleteStudent(1);
        DeleteStudent(99); // not found case

        Console.WriteLine("\n=== READ (all, after delete) ===");
        PrintAllStudents();
    }

    // ===== Validation helper =====
    // Runs all [Required]/[StringLength]/[Range]/[EmailAddress] checks on
    // a Student object, the same rules an EditForm would enforce.
    private static bool TryValidate(Student s, out List<string> errors)
    {
        var context = new ValidationContext(s);
        var results = new List<ValidationResult>();
        bool isValid = Validator.TryValidateObject(s, context, results, validateAllProperties: true);

        errors = results.Select(r => r.ErrorMessage ?? "Invalid value").ToList();
        return isValid;
    }

    // ===== CREATE =====
    private static void AddStudent(Student s)
    {
        if (!TryValidate(s, out var errors))
        {
            Console.WriteLine($"Add failed for '{s.Name}':");
            foreach (var e in errors) Console.WriteLine($"  - {e}");
            return;
        }

        s.Id = nextId++;
        students.Add(s);
        Console.WriteLine($"Added Id={s.Id}, Name={s.Name}");
    }

    // ===== READ =====
    private static Student? FindStudent(int id)
    {
        return students.FirstOrDefault(s => s.Id == id);
    }

    private static void FindAndPrint(int id)
    {
        var s = FindStudent(id);
        Console.WriteLine(s is not null
            ? $"Found: Id={s.Id}, Name={s.Name}, Age={s.Age}, Email={s.Email}"
            : $"No student found with Id={id}");
    }

    private static void PrintAllStudents()
    {
        if (students.Count == 0)
        {
            Console.WriteLine("(no students)");
            return;
        }
        foreach (var s in students)
        {
            Console.WriteLine($"Id={s.Id}, Name={s.Name}, Age={s.Age}, Email={s.Email}");
        }
    }

    // ===== UPDATE =====
    private static void UpdateStudent(int id, string newName, int newAge, string newEmail)
    {
        var existing = FindStudent(id);
        if (existing is null)
        {
            Console.WriteLine($"Update failed: no student with Id={id}");
            return;
        }

        // Build a temporary copy to validate BEFORE committing changes,
        // so a bad update doesn't corrupt the real record.
        var proposed = new Student { Id = existing.Id, Name = newName, Age = newAge, Email = newEmail };

        if (!TryValidate(proposed, out var errors))
        {
            Console.WriteLine($"Update failed for Id={id}:");
            foreach (var e in errors) Console.WriteLine($"  - {e}");
            return;
        }

        existing.Name = proposed.Name;
        existing.Age = proposed.Age;
        existing.Email = proposed.Email;
        Console.WriteLine($"Updated Id={id} -> Name={existing.Name}, Age={existing.Age}, Email={existing.Email}");
    }

    // ===== DELETE =====
    private static void DeleteStudent(int id)
    {
        int removed = students.RemoveAll(s => s.Id == id);
        Console.WriteLine(removed > 0
            ? $"Deleted Id={id}"
            : $"Delete failed: no student with Id={id}");
    }
}