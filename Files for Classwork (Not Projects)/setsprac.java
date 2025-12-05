/*
* NAME: Thomas Mairella
* DATE: // 11/19/25
* VERSION: // v1
* COMMENTS / NOTES:
* - This is for an assignment :)
*/

import java.util.HashSet;
import java.util.Set;

public class setsprac {
    public static void main(String[] args) {
    
        // Make New HashSet
        Set<String> students = new HashSet<>();

        // Student Set
        students.add("John");
        students.add("Shawn");
        students.add("Kelly");
        students.add("Aiden");
        students.add("John");
        students.remove("Aiden");

        // Check if These Students are in Class
        boolean nameAiden = students.contains("Aiden");
        boolean nameKelly = students.contains("Kelly");

        System.out.println("Is there a Aiden in class: " + nameAiden);
        System.out.println("Is there a Kelly in class: " + nameKelly);

        // Print Set of Students
        System.out.println("\nList of Students in class:");

        for (String names : students) {
            System.out.println(names);
        }
  }
}
