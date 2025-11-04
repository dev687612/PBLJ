import java.util.*;
import java.util.stream.*;

class Student {
    private String name;
    private double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() { return name; }
    public double getMarks() { return marks; }

    @Override
    public String toString() {
        return String.format("%s - %.2f%%", name, marks);
    }
}

public class PracticeB {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 82.5),
                new Student("Bob", 68.0),
                new Student("Charlie", 90.3),
                new Student("David", 74.2),
                new Student("Eva", 88.5)
        );

        System.out.println("Students scoring above 75%, sorted by marks:\n");

        // Stream operations: filter, sort, map, forEach
        students.stream()
                .filter(s -> s.getMarks() > 75)
                .sorted(Comparator.comparingDouble(Student::getMarks))
                .map(Student::getName)
                .forEach(System.out::println);
    }
}
