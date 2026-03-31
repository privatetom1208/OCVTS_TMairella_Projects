/*
* NAME: Thomas Mairella
* DATE: // 11/20/25
* VERSION: // v1
* COMMENTS / NOTES:
* - This is for an assignment :)
*/

import java.util.HashMap;

public class mapsprac {
    public static void main(String[] args) {
    
        // Make a New HashMap
        HashMap<String, Integer> studentIds = new HashMap<>();

        // Student List of IDS
        studentIds.put("John", 39462);
        studentIds.put("Stacy", 32547);
        studentIds.put("Patrick", 56638);
        studentIds.put("Emily", 84573);
        studentIds.put("Aaron", 19578);
        studentIds.put("Megan", 18468);

        studentIds.remove("Megan");

        System.out.println("\nAaron's ID number:");
        int aaronNum = studentIds.get("Aaron");
        System.out.println(aaronNum);

        // Have Keys Test
        System.out.println("\nDoes Aaron have a key?");
        boolean aaronKey = studentIds.containsKey("Aaron");
        System.out.println(aaronKey);
        System.out.println("\nDoes Megan have a key?");
        boolean meganKey = studentIds.containsKey("Megan");
        System.out.println(meganKey);

        // Print All Students & Keys
        System.out.println("\nList of all student & IDs:");
        System.out.println(studentIds);

  }
}
