import java.util.ArrayList;

public class StudentTest {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(105, "Emma", "Denver"));
        students.add(new Student(102, "Liam", "Chicago"));
        students.add(new Student(110, "Olivia", "Dallas"));
        students.add(new Student(101, "Noah", "Seattle"));
        students.add(new Student(108, "Sophia", "Atlanta"));
        students.add(new Student(103, "James", "Boston"));
        students.add(new Student(107, "Ava", "Miami"));
        students.add(new Student(109, "Mason", "Phoenix"));
        students.add(new Student(104, "Isabella", "Houston"));
        students.add(new Student(106, "Ethan", "San Diego"));

        System.out.println("Original List:");
        displayStudents(students);

        SelectionSort.selectionSort(students, new NameComparator());

        System.out.println("\nSorted by Name:");
        displayStudents(students);

        SelectionSort.selectionSort(students, new RollNoComparator());

        System.out.println("\nSorted by Roll Number:");
        displayStudents(students);
    }

    private static void displayStudents(ArrayList<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}