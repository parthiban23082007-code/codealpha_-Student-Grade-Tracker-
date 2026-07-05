import java.util.ArrayList;
import java.util.Scanner;

public class StudentGT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> grades = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            names.add(scanner.nextLine());
            System.out.print("Enter grade for " + names.get(i) + ": ");
            grades.add(scanner.nextDouble());
            scanner.nextLine(); // consume newline
        }

        if (names.isEmpty()) {
            System.out.println("No students entered.");
            scanner.close();
            return;
        }

        // Calculations
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        String topStudent = "";
        String lowStudent = "";

        for (int i = 0; i < grades.size(); i++) {
            double grade = grades.get(i);
            total += grade;
            if (grade > highest) {
                highest = grade;
                topStudent = names.get(i);
            }
            if (grade < lowest) {
                lowest = grade;
                lowStudent = names.get(i);
            }
        }

        double average = total / grades.size();

        // Output
        System.out.println("\n--- Student Grades Summary ---");
        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%s: %.2f%n", names.get(i), grades.get(i));
        }
        System.out.printf("Average Score: %.2f%n", average);
        System.out.printf("Highest Score: %.2f (%s)%n", highest, topStudent);
        System.out.printf("Lowest Score: %.2f (%s)%n", lowest, lowStudent);

        scanner.close();
    }
}
