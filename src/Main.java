import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager();
        Scanner scanner = new Scanner(System.in);

        manager.loadFromFile("students.txt");
        manager.displayStudents();
        manager.showStatistics();
        manager.showPassedAndFailed();

        // Add student
        manager.addStudent(new Student(111, "Lucie", 24, 75));

        // Update score
        manager.updateScore(104, 60);

        manager.saveToFile("students.txt");

        scanner.close();
    }
}
