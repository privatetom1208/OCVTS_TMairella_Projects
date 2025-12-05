import java.util.Scanner;

public class TMairella_thenamegame_v1 {
  public static void main(String[] args) {
    
    // Variables
    int number;

    // User Input
    Scanner input = new Scanner(System.in);
    System.out.print("Enter a number to start countdown: ");
    number = input.nextInt();

    // Logic
    while (number >= 0) {
        if (number == 5) {
            System.out.println("Almost there!");
        } else if (number == 0) {
            System.out.println("Blast off!");
        } else {
            System.out.println(number);
        }
        number--;
    }

    // Close Scanner
    input.close();
  }
}