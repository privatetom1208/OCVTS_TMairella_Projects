import java.util.Scanner;

public class puzzle_ex {
    public static void main(String[] args) {
        
        // Variables
        final String CORRECT_PASSWORD = "purple-green-yellow-blue-orange-pink-red";
        String userInput;
        char reply;

        // User Input Scanner
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Enter your password (EX: blue-green-yellow-orange): ");
            userInput = input.next().toUpperCase();

         // Logic
            if (CORRECT_PASSWORD.toUpperCase().equals(userInput)) {
                System.out.println("\nCorrect! The safe is now unlocked, and inside it reads:");
                System.out.println("Dark Blue");
                break;
            } else {
                System.out.println("\nIncorrect, try again with a different passcode? (y/n)");

                String choiceInput = input.next().toUpperCase();
                
                if (choiceInput.isEmpty()) {
                    reply = 'N'; 
                } else {
                    reply = choiceInput.charAt(0);
                }

                if (reply == 'Y') {
                } else if (reply == 'N') {
                    System.out.println("Stopping Program...");
                    break;
                }
            }
        }
        input.close();
    }
}