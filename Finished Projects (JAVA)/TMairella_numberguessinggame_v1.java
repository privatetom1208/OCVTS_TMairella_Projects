import java.util.*; 

public class TMairella_numberguessinggame_v1{ 
    public static void main(String[] args) {
        
        int randomNum = (int)(Math.random() * 100) + 1;
        int userguess = 0;
        int attempts = 0;
        Scanner input = new Scanner(System.in);
      
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a random number between 1 and 100.");
        System.out.println("Try to guess the number, and I will tell you if it's higher or lower.");

        while (userguess != randomNum) {
            System.out.print("Enter your guess: ");
            userguess = input.nextInt();
            attempts++;
            if (userguess > randomNum) {
                System.out.println("Lower (Attempts so far: " + attempts + ")");
            } else if (userguess < randomNum) {
                System.out.println("Higher (Attempts so far: " + attempts + ")");
            } else {
                System.out.println("Congrats, You got the number right! The number was " + randomNum);
                System.out.println("You got the correct number in " + attempts + " attempts!");
            }
        }
        input.close();
     }
} 