/*
* NAME: Thomas Mairella
* DATE: // 11/10/25
* VERSION: // v1
* COMMENTS / NOTES:
* - This is a class assignment (Coding Challenge)
*/

import java.util.*; 
public class TMairella_cakeboxproblem_v1 {
    public static void main(String[] args) {
        
        //Variables
        int boxes;
        int slices;
        int guests;
        int totalSlices;
        int dividedSlices;
        int remainingSlices;

        //Get Variables
        Scanner input = new Scanner(System.in);
        System.out.print("Enter amount of cake boxes: ");
        boxes = input.nextInt();
        System.out.print("Enter amount of cake slices per cake: ");
        slices = input.nextInt();
        System.out.print("Enter amount of guests: ");
        guests = input.nextInt();

        // Equations
        totalSlices = (boxes * slices);
        dividedSlices = (totalSlices / guests);
        remainingSlices = (totalSlices % guests);

        // Print Result
        System.out.println("\nPrinting results…\n");
        System.out.println("Each guest gets " + dividedSlices + " slices of cake.");
        System.out.println("There are " + remainingSlices + " slices left over.");

        // Close Scanner
        input.close();
  }
}