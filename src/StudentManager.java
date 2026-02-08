import java.io.*;
import java.util.*;

public class StudentManager {

    private List<Student> students = new ArrayList<>();

    // 1. READ FROM FILE
    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length != 4) {
                    throw new IllegalArgumentException("Invalid data format");
                }

                int id = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());
                int score = Integer.parseInt(parts[3].trim());

                students.add(new Student(id, name, age, score));
            }

            if (students.isEmpty()) {
                System.out.println("File is empty.");
            } else {
                System.out.println("Loaded " + students.size() + " students from the file.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error reading file.");
        } catch (Exception e) {
            System.out.println("Error: Invalid data in file.");
        }
    }

    // 2. DISPLAY ALL STUDENTS
    public void displayStudents() {
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    // 3. PROCESSING
    public void showStatistics() {
        if (students.isEmpty()) return;

        int total = 0;
        Student highest = students.get(0);
        Student lowest = students.get(0);

        for (Student s : students) {
            total += s.getScore();

            if (s.getScore() > highest.getScore())
                highest = s;

            if (s.getScore() < lowest.getScore())
                lowest = s;
        }

        double average = (double) total / students.size();

        System.out.println("\nAverage score: " + average);
        System.out.println("Top student: " + highest.getName() + " (" + highest.getScore() + ")");
        System.out.println("Lowest student: " + lowest.getName() + " (" + lowest.getScore() + ")");
    }

    // 4. FILTER PASS / FAIL
    public void showPassedAndFailed() {
        System.out.println("\nStudents who failed:");
        boolean anyFailed = false;

        for (Student s : students) {
            if (s.getScore() < 60) {
                System.out.println(s);
                anyFailed = true;
            }
        }

        if (!anyFailed) {
            System.out.println("None");
        }
    }

    // 5. ADD STUDENT
    public void addStudent(Student student) {
        students.add(student);
    }

    // 6. UPDATE SCORE
    public void updateScore(int id, int newScore) {
        for (Student s : students) {
            if (s.getId() == id) {
                s.setScore(newScore);
                System.out.println("Score updated.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // 7. SAVE BACK TO FILE
    public void saveToFile(String fileName) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            for (Student s : students) {
                pw.println(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getAge() + "," +
                                s.getScore()
                );
            }
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
}
