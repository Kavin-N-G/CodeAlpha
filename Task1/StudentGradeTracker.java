import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
public class StudentGradeTracker {
    public static void main(String[] args) {
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Student Grade Tracker!");
        System.out.println("=====================================\n");
        int numStudents = getNumberOfStudents(scanner);
        inputGrades(grades, numStudents, scanner);
        displayResults(grades);
    }
    private static int getNumberOfStudents(Scanner scanner) {
        int numStudents = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.print("Enter the number of students: ");
                numStudents = scanner.nextInt();
                if (numStudents <= 0) {
                    System.out.println("Number of students must be greater than 0.");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }
        return numStudents;
    }
    private static void inputGrades(ArrayList<Integer> grades, int numStudents, Scanner scanner) {
        System.out.println("\nPlease enter the grades for " + numStudents + " students:");
        for (int i = 1; i <= numStudents; i++) {
            int grade = 0;
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Enter grade for student " + i + " (0-100): ");
                    grade = scanner.nextInt();
                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100.");
                    } else {
                        validInput = true;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next();
                }
            }
            grades.add(grade);
        }
    }
    private static void displayResults(ArrayList<Integer> grades) {
        int totalGrades = grades.size();
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        double average = sum / (double) totalGrades;
        int highestGrade = Collections.max(grades);
        int lowestGrade = Collections.min(grades);
        System.out.println("\n=================== Results ===================");
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Highest Grade: " + highestGrade);
        System.out.println("Lowest Grade: " + lowestGrade);
        System.out.println("===============================================");
    }
}