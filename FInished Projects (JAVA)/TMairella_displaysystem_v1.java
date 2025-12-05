/*
* NAME: Thomas Mairella
* DATE: // 12/7/25
* VERSION: // v1
* SOURCES USED:
// https://gemini.google.com/ (Corrections, Error Fixes, & Overall Help)
// https://www.geeksforgeeks.org/java/carriage-return-in-java/ (Learned Carriage Return to write over previous time printed)
// https://www.w3schools.com/java/java_date.asp (Used for getting time and formatting)
* COMMENTS / NOTES:
* - This is a display system in Java. You can view the times in multiple places 
    with different timezones and view them in 12 or 24 hour formats.
* - Instructions: Run program, enter the time format you'd like to use, 
    and see what time it is around the world!
*/

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TMairella_displaysystem_v1 {

    public static void main(String[] args) {
        // All time zones
        String[] timeZones = {
            "UTC",
            "America/New_York",
            "Europe/Berlin",
            "Asia/Tokyo",
            "Australia/Sydney",
            "America/Los_Angeles"
        };

        Scanner scanner = new Scanner(System.in);
        String formatPattern;
        
        // Ask user for time format
        System.out.println("Welcome to the World Digital Clock.");
        System.out.print("Do you want 12-hour or 24-hour format? (Enter 12 or 24): ");
        
        // Loop for input
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice == 12) {
                    formatPattern = "hh:mm:ss a z";
                    System.out.println("\nDisplaying time in 12-hour format (e.g., 03:30:00 PM).");
                    break;
                } else if (choice == 24) {
                    formatPattern = "HH:mm:ss z";
                    System.out.println("\nDisplaying time in 24-hour format (e.g., 15:30:00).");
                    break;
                }
            }
            System.out.print("Invalid input. Please enter 12 or 24: ");
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }
        }
        scanner.close();

        // Create formatter object based on user's choice
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);

        System.out.println("Starting Clock... (Press Ctrl+C to exit)\n");

        // The main clock loop
        while (true) {
            try {
                // Get the current time
                ZonedDateTime currentTime = ZonedDateTime.now();
                StringBuilder displayOutput = new StringBuilder();

                // Loop through each time zone
                for (String zoneIdString : timeZones) {
                    ZoneId zone = ZoneId.of(zoneIdString);

                    ZonedDateTime zonedTime = currentTime.withZoneSameInstant(zone);

                    String formattedTime = zonedTime.format(formatter);

                    displayOutput.append(String.format("%-25s", formattedTime));
                }

                // Refresh logic
                System.out.print("\r" + displayOutput.toString());
                Thread.sleep(1000); 

            } catch (InterruptedException e) {
                // If the thread is interrupted by Ctrl+C
                System.out.println("\nClock stopped.");
                Thread.currentThread().interrupt();
                break;
            } catch (Exception e) {
                 // Catch any other potential errors
                System.err.println("\nAn unexpected error occurred: " + e.getMessage());
                break;
            }
        }
    }
}