/*
* NAME: Thomas Mairella
* DATE: // 11/23/25
* VERSION: // v1
* SOURCES USED:
// https://gemini.google.com/ (Corrections, Error Fixes, & Overall Help)
// https://springframework.guru/sorting-java-arraylist/ (Helped Sorting Arraylist)
// https://www.w3schools.com/java/ref_math_round.asp (Helped to Get Rounded Numbers for Letter Grade)
// https://www.w3schools.com/java/ref_string_format.asp (Helped to Format Variables)
// https://www.w3schools.com/java/ref_string_contains.asp (Helped Make Search Function Work)
* COMMENTS / NOTES:
* - This is a Student Grade Tracker. See all your student grade with this simple tool. Just run and enjoy. 
    You can sort by Grade or by Alphabetical, and you can search for students. It also displays the class average!
* - Instructions: Run the program, and enjoy seeing all your students grades, averages, & more!
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class TMairella_studentgradetracker_v1 {

    // Student Class
    public static class Student {
        public String firstName;
        public String lastName;
        public int age;
        public String gradeLevel;
        public double gradeScore;

        public Student(String fName, String lName, int sAge, String gLevel, double gScore) {
            this.firstName = fName;
            this.lastName = lName;
            this.age = sAge;
            this.gradeLevel = gLevel;
            this.gradeScore = gScore;
        }
        
        // Get Full Name
        public String getName() {
            return firstName + " " + lastName;
        }

        // Number to Letter Grade Logic
        public String getLetterGrade() {
            long roundedScore = Math.round(gradeScore); 
            if (roundedScore >= 92) { 
                return "A";
            } else if (roundedScore >= 83) { 
                return "B";
            } else if (roundedScore >= 74) { 
                return "C";
            } else if (roundedScore >= 65) { 
                return "D";
            } else {
                return "F";
            }
        }
    }

    // Main Class
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        ArrayList<Student> studentList = initializeStudents();

        int choice = -1;

        // Main Loop (until user exits)
        while (choice != 0) {

            displayStudents(studentList, "CURRENT STUDENT LIST & GRADES");
            calculateStats(studentList);

            displayMenu();

            if (keyboard.hasNextInt()) {
                choice = keyboard.nextInt();
                keyboard.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("\n*** Sorting by Grade (Highest -> Lowest) ***\n");
                        collectionsSortByGrade(studentList);
                        break;
                    case 2:
                        System.out.println("\n*** Sorting by Name (Alphabetical) ***\n");
                        collectionsSortByName(studentList);
                        break;
                    case 3:
                        System.out.print("\nEnter student name to search: ");
                        String searchName = keyboard.nextLine();
                        searchStudent(studentList, searchName, keyboard);
                        break;
                    case 0:
                        System.out.println("\nExiting the Student Grade Tracker. Goodbye!");
                        break;
                    default:
                        System.out.println("\nInvalid choice. Please enter a number from the menu.\n");
                        break;
                }
            } else {
                System.out.println("\nInvalid input. Please enter a number.\n");
                keyboard.nextLine();
                choice = -1;
            }
        }
        // Close Scanner
        keyboard.close();
    }

    // ArrayList of Students
    public static ArrayList<Student> initializeStudents() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Alice", "Smith", 15, "Sophomore", 92.4)); 
        students.add(new Student("Bob", "Johnson", 14, "Freshman", 65.5)); 
        students.add(new Student("Charlie", "Williams", 16, "Junior", 88.4)); 
        students.add(new Student("Diana", "Brown", 14, "Freshman", 73.1)); 
        students.add(new Student("Ethan", "Jones", 17, "Senior", 95.8)); 
        students.add(new Student("Fiona", "Garcia", 15, "Sophomore", 59.3)); 
        students.add(new Student("George", "Miller", 16, "Junior", 81.6)); 
        students.add(new Student("Hannah", "Moore", 17, "Senior", 77.1)); 
        students.add(new Student("Ian", "Davis", 15, "Sophomore", 60.9)); 
        students.add(new Student("Anna", "Wilson", 14, "Freshman", 99.7)); 
        students.add(new Student("Kelly", "Taylor", 16, "Junior", 85.2)); 
        students.add(new Student("Liam", "Jackson", 17, "Senior", 70.4)); 
        return students;
    }

    // Display Menu Options
    public static void displayMenu() {
        System.out.println("\n=========================================");
        System.out.println("## SELECT AN OPTION ##");
        System.out.println("1. Sort students by Grade Score (Highest -> Lowest)");
        System.out.println("2. Sort students by Name (Alphabetical)");
        System.out.println("3. Search for a Student by Name");
        System.out.println("0. Exit Program");
        System.out.println("=========================================");
        System.out.print("Enter your choice (0-3): ");
    }

    // Displays Student ArrayList
    public static void displayStudents(ArrayList<Student> students, String title) {
        System.out.println("\n--- " + title + " ---");
        for (Student s : students) {
            String gradeDisplay = String.format("%.1f", s.gradeScore);
            String output = s.getName() + " (Age: " + s.age + ", Grade Level: " + s.gradeLevel + "): " + gradeDisplay + " (" + s.getLetterGrade() + ")";
            System.out.println(output);
        }
    }

    // Calculate & Display Student Stats
    public static void calculateStats(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students to calculate stats.");
            return;
        }

        double totalGrade = 0;
        double highest = -1.0; 
        double lowest = 101.0;

        // Find the Total, High, and Low Grades of Students
        for (Student s : students) {
            totalGrade = totalGrade + s.gradeScore; 
            if (s.gradeScore > highest) { 
                highest = s.gradeScore;
            }
            if (s.gradeScore < lowest) { 
                lowest = s.gradeScore;
            }
        }

        double average = totalGrade / students.size(); 

        System.out.println("\n--- CLASS STATISTICS ---");
        String roundedAverage = String.format("%.2f", (double) Math.round(average * 100) / 100);
        String highestDisplay = String.format("%.1f", highest);
        String lowestDisplay = String.format("%.1f", lowest);
        
        System.out.println("Average Grade Score: " + roundedAverage);
        System.out.println("Highest Grade Score: " + highestDisplay);
        System.out.println("Lowest Grade Score: " + lowestDisplay);
    }

    // Sort by Grade
    public static void collectionsSortByGrade(ArrayList<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Double.compare(s2.gradeScore, s1.gradeScore); 
            }
        });
    }

    // Sort by Alphabetical
    public static void collectionsSortByName(ArrayList<Student> students) {
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getName().compareTo(s2.getName());
            }
        });
    }

    // Search Function
    public static void searchStudent(ArrayList<Student> students, String searchName, Scanner keyboard) {
        System.out.println("\n## Search Results for \"" + searchName + "\" ##");
        boolean found = false;
        String lowerCaseSearch = searchName.toLowerCase().trim();

        for (Student s : students) {
            if (s.getName().toLowerCase().contains(lowerCaseSearch)) { 
                String gradeDisplay = String.format("%.1f", s.gradeScore);
                System.out.println("-> Found: " + s.getName() + " (Grade Score: " + gradeDisplay + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("-> No student found matching \"" + searchName + "\".");
        }
        System.out.println("\nPress Enter to return to the menu...");
        keyboard.nextLine();
    }
}