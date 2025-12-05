/*
* NAME: Thomas Mairella
* DATE: // 10/05/25
* VERSION: // v1
* SOURCES USED:
// https://stackoverflow.com/questions/20536566/creating-a-random-string-with-a-z-and-0-9-in-java
// https://www.programiz.com/java-programming/examples/generate-random-string
// https://gemini.google.com/
* COMMENTS / NOTES:
* - This is a Password Generator, It takes your desired password length and generates a brand new password for you to use. 
    If you enter a number lower than 8 or higher than 15, it will pop up with an error.
    You can also choose to have numbers and symbols or just letters.
* - Instructions: Run program, enter how long you want your password to be, choose if you want numbers and symbols, and enjoy your new secure password.
*/

import java.util.Random;
import java.util.Scanner;

public class TMairella_passwordgenerator_v1 {
    public static void main(String[] args) {
        
        // Variables
        int length;
        final int min = 8;
        final int max = 15;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String allchars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*_+;:,.<>?";
        char symbol;

        // Get Password Length & Type
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome, This is a Password Generator!");
        System.out.print("How long will your password be?: ");
        length = input.nextInt();
        System.out.println("Want to include symbols & numbers? (y/n)");
        symbol = input.next().toUpperCase().charAt(0);

        // Generate Either Type of Password
        Random pass = new Random();
            // Error Messages
        if (length < min || length > max) {
            System.out.println("Sorry, password length must be " + min + "-" + max + " characters long.");
        } else if (symbol != 'Y' && symbol != 'N') {
            System.out.println("Error invalid input, please enter 'y' or 'n'.");
            // Passwords with 'chars'
        } else if (symbol == 'N') {
            System.out.println("Generating 5 passwords with letters only...");
            for (int count = 1; count <= 5; count++) {
                StringBuilder password = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    int index = pass.nextInt(chars.length());
                    password.append(chars.charAt(index));
                }
                System.out.println(count + ". " + password.toString());
            }
            // Passwords with 'allchars'
        } else if (symbol == 'Y') {
            System.out.println("Generating 5 passwords with letters, numbers, and symbols...");
            for (int count = 1; count <= 5; count++) {
                StringBuilder password = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    int index = pass.nextInt(allchars.length());
                    password.append(allchars.charAt(index));
                }
                System.out.println(count + ". " + password.toString());
            }
        }
        input.close();
    }
}